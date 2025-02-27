package edu.itsu.inscripciones.controlador;

import edu.itsu.inscripciones.modelo.Correlatividades;
import edu.itsu.inscripciones.servicio.ICorrelatividadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class CorrelatividadesControlador {
    @Autowired
    private ICorrelatividadesServicio servicio;

    @GetMapping("/correlatividades")
    public List<Correlatividades> listar() {
        return servicio.listarCorrelatividades();
    }

    @PostMapping("/correlatividades")
    public Correlatividades crear(@RequestBody Correlatividades correlatividad) {
        return servicio.guardarCorrelatividad(correlatividad);
    }

    @PutMapping("/correlatividades/{id}")
    public Correlatividades actualizar(@PathVariable Integer id, @RequestBody Correlatividades correlatividad) {
        correlatividad.setIdCorrelatividad(id);
        return servicio.guardarCorrelatividad(correlatividad);
    }

    @DeleteMapping("/correlatividades/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarCorrelatividad(id);
    }
}