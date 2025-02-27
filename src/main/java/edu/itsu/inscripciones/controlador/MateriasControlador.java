package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.servicio.IMateriasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class MateriasControlador {
    @Autowired
    private IMateriasServicio servicio;

    @GetMapping("/materias")
    public List<Materias> listar() {
        return servicio.listarMaterias();
    }

    @PostMapping("/materias")
    public Materias crear(@RequestBody Materias materia) {
        return servicio.guardarMateria(materia);
    }

    @PutMapping("/materias/{id}")
    public Materias actualizar(@PathVariable Integer id, @RequestBody Materias materia) {
        materia.setIdMateria(id);
        return servicio.guardarMateria(materia);
    }

    @DeleteMapping("/materias/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarMateria(id);
    }
}