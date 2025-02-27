package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.Notas;
import edu.itsu.inscripciones.servicio.INotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class NotasControlador {
    @Autowired
    private INotasServicio servicio;

    @GetMapping("/notas")
    public List<Notas> listar() {
        return servicio.listarNotas();
    }

    @PostMapping("/notas")
    public Notas crear(@RequestBody Notas nota) {
        return servicio.guardarNota(nota);
    }

    @PutMapping("/notas/{id}")
    public Notas actualizar(@PathVariable Integer id, @RequestBody Notas nota) {
        nota.setIdNota(id);
        return servicio.guardarNota(nota);
    }

    @DeleteMapping("/notas/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarNota(id);
    }
}
