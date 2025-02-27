package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Correlatividades;
import edu.itsu.inscripciones.modelo.InscripcionesAExamenes;
import edu.itsu.inscripciones.modelo.Notas;
import edu.itsu.inscripciones.repositorio.CorrelatividadesRepositorio;
import edu.itsu.inscripciones.repositorio.InscripcionesAExamenesRepositorio;
import edu.itsu.inscripciones.repositorio.NotasRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesAExamenesServicio implements IInscripcionesAExamenesServicio {

    private final InscripcionesAExamenesRepositorio inscripcionesAExamenesRepositorio;
    @Autowired
    private CorrelatividadesRepositorio correlatividadesRepositorio;

    @Autowired
    private NotasRepositorio notasRepositorio;

    @Autowired
    public InscripcionesAExamenesServicio(InscripcionesAExamenesRepositorio inscripcionesAExamenesRepositorio) {
        this.inscripcionesAExamenesRepositorio = inscripcionesAExamenesRepositorio;
    }

    @Override
    public List<InscripcionesAExamenes> listarInscripciones() {
        return inscripcionesAExamenesRepositorio.findAll();
    }

    @Override
    public Optional<InscripcionesAExamenes> buscarInscripcionPorId(Long id) {
        return inscripcionesAExamenesRepositorio.findById(id);
    }

    @Override
    public InscripcionesAExamenes guardarInscripcion(InscripcionesAExamenes inscripcion) {
        List<Correlatividades> correlativas = correlatividadesRepositorio.findByMateria(inscripcion.getCatedra());
        for (Correlatividades corr : correlativas) {
            Optional<Notas> nota = notasRepositorio.findByUsuarioAndMateria(
                    inscripcion.getUsuario(), corr.getMateriaCorrelativa());
            if (nota.isEmpty() || nota.get().getNotaFinal() < 6) {
                throw new RuntimeException("Correlativa: " + corr.getMateriaCorrelativa().getNombre() + " NO APROBADA");
            }
        }
        return inscripcionesAExamenesRepositorio.save(inscripcion);
    }

    @Override
    public void eliminarInscripcion(Long id) {
        inscripcionesAExamenesRepositorio.deleteById(id);
    }
}