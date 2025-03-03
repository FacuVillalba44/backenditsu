package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.*;
import edu.itsu.inscripciones.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesAExamenesServicio implements IInscripcionesAExamenesServicio {
    @Autowired
    private InscripcionesAExamenesRepositorio inscripcionesAExamenesRepositorio;

    @SuppressWarnings("unused")
    @Autowired
    private LlamadosAMesaRepositorio llamadosAMesaRepositorio;

    @Autowired
    private NotasRepositorio notasRepositorio;

    @Autowired
    private CorrelatividadesRepositorio correlatividadesRepositorio;

    @Autowired
    private PeriodoDeInscripcionServicio periodoServicio;

    @Override
    public List<InscripcionesAExamenes> listarInscripciones() {
        return inscripcionesAExamenesRepositorio.findAll();
    }

    @Override
    public Optional<InscripcionesAExamenes> buscarPorId(Long id) {
        return inscripcionesAExamenesRepositorio.findById(id);
    }

    @Override
    public InscripcionesAExamenes guardarInscripcion(InscripcionesAExamenes inscripcion) {
        LocalDateTime ahora = LocalDateTime.now();
        inscripcion.setFechaDeInscripcion(ahora);
        inscripcion.setEstado("enviada");

        // Verifica que el llamado esté definido
        LlamadosAMesa llamado = inscripcion.getIdLlamado();
        if (llamado == null) {
            throw new RuntimeException("El llamado no está definido en la inscripción");
        }

        // Carga la materia desde el llamado
        Materias materia = llamado.getIdMateria();
        if (materia == null) {
            throw new RuntimeException("La materia no está definida en el llamado");
        }

        // Verifica si la materia ya está aprobada
        Optional<Notas> notaExistente = notasRepositorio.findByUsuarioIdUsuarioAndMateriaIdMateria(
            inscripcion.getUsuario().getIdUsuario(), materia.getIdMateria());
        if (notaExistente.isPresent() && notaExistente.get().getNotaFinal() >= 6) {
            throw new RuntimeException("La materia " + materia.getNombre() + " ya está aprobada");
        }

        // Valida el período de inscripción
        List<PeriodoDeInscripcion> periodosActivos = periodoServicio.findPeriodosActivos(ahora);
        if (periodosActivos.isEmpty()) {
            throw new RuntimeException("Inscripción fuera del período permitido");
        }

        // Valida doble inscripción y asigna llamado
        List<InscripcionesAExamenes> existentes = inscripcionesAExamenesRepositorio.findByUsuarioAndIdLlamadoIdMateria(
            inscripcion.getUsuario(), materia);
        int numInscripciones = existentes.size();
        if (numInscripciones >= 2) {
            throw new RuntimeException("Ya existen dos inscripciones para la materia " + materia.getNombre());
        }
        inscripcion.setLlamado(numInscripciones + 1);

        // Valida correlativas si no es ciclo 1
        if (materia.getCiclo() != 1) {
            List<Correlatividades> correlativas = correlatividadesRepositorio.findByMateria(materia);
            if (!correlativas.isEmpty()) {
                for (Correlatividades corr : correlativas) {
                    Optional<Notas> nota = notasRepositorio.findByUsuarioIdUsuarioAndMateriaIdMateria(
                        inscripcion.getUsuario().getIdUsuario(), corr.getMateriaCorrelativa().getIdMateria());
                    if (nota.isEmpty() || nota.get().getNotaFinal() < 6) {
                        throw new RuntimeException("Correlativa " + corr.getMateriaCorrelativa().getNombre() + " no aprobada");
                    }
                }
            }
        }

        return inscripcionesAExamenesRepositorio.save(inscripcion);
    }

    @Override
    public void eliminarInscripcion(Long id) {
        inscripcionesAExamenesRepositorio.deleteById(id);
    }
}