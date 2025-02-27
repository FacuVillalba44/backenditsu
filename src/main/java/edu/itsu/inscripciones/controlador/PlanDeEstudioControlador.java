package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.PlanDeEstudio;
import edu.itsu.inscripciones.servicio.IPlanDeEstudioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi/planes")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class PlanDeEstudioControlador {
    @Autowired
    private IPlanDeEstudioServicio servicio;

    @GetMapping
    public List<PlanDeEstudio> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public PlanDeEstudio crear(@RequestBody PlanDeEstudio plan) {
        return servicio.guardar(plan);
    }

    @PutMapping("/{id}")
    public PlanDeEstudio actualizar(@PathVariable Integer id, @RequestBody PlanDeEstudio plan) {
        plan.setIdPlanDeEstudio(id);
        return servicio.guardar(plan);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
    }
}