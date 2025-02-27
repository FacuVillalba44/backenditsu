package edu.itsu.inscripciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.itsu.inscripciones.servicio.IInscripcionesAExamenesServicio;
import edu.itsu.inscripciones.modelo.InscripcionesAExamenes;
import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class InscripcionesAExamenesControlador {

    @Autowired
    private IInscripcionesAExamenesServicio servicio;

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
}
