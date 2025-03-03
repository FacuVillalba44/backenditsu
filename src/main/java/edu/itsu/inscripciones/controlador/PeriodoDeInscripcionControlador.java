package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.PeriodoDeInscripcion;
import edu.itsu.inscripciones.servicio.IPeriodoDeInscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class PeriodoDeInscripcionControlador {
    @Autowired
    private IPeriodoDeInscripcionServicio servicio;

    @GetMapping("/periodos")
    public List<PeriodoDeInscripcion> listar() {
        return servicio.listarPeriodos();
    }

    @PostMapping("/periodos")
    public PeriodoDeInscripcion crear(@RequestBody PeriodoDeInscripcion periodo) {
        return servicio.guardarPeriodo(periodo);
    }

    @PutMapping("/periodos/{id}")
    public PeriodoDeInscripcion actualizar(@PathVariable Long id, @RequestBody PeriodoDeInscripcion periodo) {
        periodo.setId(id);
        return servicio.guardarPeriodo(periodo);
    }

    @DeleteMapping("/periodos/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminarPeriodo(id);
    }
}