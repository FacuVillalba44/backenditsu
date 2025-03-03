package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.*;
import edu.itsu.inscripciones.repositorio.*;
import edu.itsu.inscripciones.servicio.IInscripcionesAExamenesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class InscripcionesAExamenesControlador {
    @Autowired
    private IInscripcionesAExamenesServicio servicio;

    @Autowired
    private LlamadosAMesaRepositorio llamadosAMesaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @SuppressWarnings("unused")
    @Autowired
    private CarreraRepositorio carreraRepositorio;

    @Autowired
    private InscripcionesCarrerasRepositorio inscripcionesCarrerasRepositorio;

    @GetMapping("/inscripciones-examenes")
    public List<InscripcionesAExamenes> listar() {
        return servicio.listarInscripciones();
    }

    @PostMapping("/inscripciones-examenes")
    public InscripcionesAExamenes crear(@RequestBody InscripcionesAExamenes inscripcion) {
        return servicio.guardarInscripcion(inscripcion);
    }

    @PutMapping("/inscripciones-examenes/{id}")
    public InscripcionesAExamenes actualizar(@PathVariable Long id, @RequestBody InscripcionesAExamenes inscripcion) {
        inscripcion.setId(id);
        return servicio.guardarInscripcion(inscripcion);
    }

    @DeleteMapping("/inscripciones-examenes/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminarInscripcion(id);
    }

    @GetMapping("/inscripciones-examenes/preview/{idLlamado}")
    public InscripcionPreviewDTO obtenerPreview(@PathVariable Long idLlamado, @RequestParam("idUsuario") Integer idUsuario) {
        // Validar parámetros
        if (idUsuario == null) {
            throw new IllegalArgumentException("El parámetro idUsuario es obligatorio");
        }
        if (idLlamado == null) {
            throw new IllegalArgumentException("El parámetro idLlamado es obligatorio");
        }

        // Buscar usuario
        Usuario usuario = usuarioRepositorio.findById(idUsuario)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscar llamado
        LlamadosAMesa llamado = llamadosAMesaRepositorio.findById(idLlamado)
            .orElseThrow(() -> new RuntimeException("Llamado no encontrado"));

        // Consultar la tabla inscripciones_carreras para obtener la carrera del usuario
        InscripcionesCarreras inscripcion = inscripcionesCarrerasRepositorio.findByUsuarioIdUsuario(idUsuario)
            .orElseThrow(() -> new RuntimeException("No se encontró inscripción para el usuario"));

        // Obtener la carrera desde la inscripción
        Carrera carrera = inscripcion.getCarrera();

        // Construir el DTO de respuesta
        InscripcionPreviewDTO preview = new InscripcionPreviewDTO();
        preview.setNombreUsuario(usuario.getNombreUsuario());
        preview.setApellidoUsuario(usuario.getApellidoUsuario());
        preview.setDniUsuario(usuario.getDniUsuario());
        preview.setNombreCarrera(carrera.getNombreCarrera());
        preview.setNombreMateria(llamado.getIdMateria().getNombre());
        preview.setCiclo(llamado.getIdMateria().getCiclo());
        preview.setFechaExamen(llamado.getFechaExamen());
        return preview;
    }
}