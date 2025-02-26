package edu.itsu.inscripciones.controlador;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.servicio.CarreraServicio;

@RestController
// context-path = http://localhost:8080/itsuapi/carrera <- se vería así el url
// de la
// api
@RequestMapping("/itsuapi") // cambie el endpoint para que no quede redundante
// Puerto desde donde recibira las peticiones del front
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")

public class CarreraControlador {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarreraControlador.class);

    @Autowired
    private CarreraServicio carreraServicio;

    // url donde se conectara es http://localhost:8080/api-itsu/carreras
    @GetMapping("/carreras") // metodo para listar las carreras
    public List<Carrera> obtenerCarrera() {
        List<Carrera> carrera = this.carreraServicio.listarCarrera();
        logger.info("Obteniendo la lista de Carreras");
        carrera.forEach(carreraServicio -> logger.info(carrera.toString()));
        return carrera;
    }

    @PostMapping("/carreras")
    public Carrera agregarCarrera(@RequestBody Carrera carrera) {
        logger.info("carrera a agregar:" + carrera);
        return this.carreraServicio.guardarCarrera(carrera);

    }

    @PutMapping("/carreras/{id}")
    public Carrera editarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
        logger.info("Editando carrera con ID: " + id);
        carrera.setIdCarrera(id);
        return carreraServicio.guardarCarrera(carrera);
    }
}