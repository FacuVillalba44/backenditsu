package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.LlamadosAMesa;
import edu.itsu.inscripciones.servicio.ILlamadosAMesaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class LlamadosAMesaControlador {
    @Autowired
    private ILlamadosAMesaServicio servicio;

    @GetMapping("/llamados")
    public List<LlamadosAMesa> listar() {
        return servicio.listarLlamados();
    }

    @PostMapping("/llamados")
    public LlamadosAMesa crear(@RequestBody LlamadosAMesa llamado) {
        return servicio.guardarLlamado(llamado);
    }

    @PutMapping("/llamados/{id}")
    public LlamadosAMesa actualizar(@PathVariable Long id, @RequestBody LlamadosAMesa llamado) {
        llamado.setId(id);
        return servicio.guardarLlamado(llamado);
    }

    @DeleteMapping("/llamados/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminarLlamado(id);
    }
}