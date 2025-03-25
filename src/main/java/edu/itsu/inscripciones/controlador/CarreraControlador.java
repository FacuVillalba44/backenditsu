package edu.itsu.inscripciones.controlador;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.modelo.PlanDeEstudio;
import edu.itsu.inscripciones.servicio.CarreraServicio;
import edu.itsu.inscripciones.servicio.PlanDeEstudioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
// context-path = http://localhost:8080/itsuapi/carrera <- se vería así el url
// de la
// api
@RequestMapping("/itsuapi") // cambie el endpoint para que no quede redundante
// Puerto desde donde recibira las peticiones del front
@CrossOrigin(origins = "https://4200-idx-webitsufrontgit-1741105155648.cluster-ve345ymguzcd6qqzuko2qbxtfe.cloudworkstations.dev")

public class CarreraControlador {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarreraControlador.class);

    @Autowired
    private CarreraServicio carreraServicio;
    @Autowired
    private PlanDeEstudioServicio planDeEstudioServicio;

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
        if (carrera.getPlanDeEstudio() == null || carrera.getPlanDeEstudio().getIdPlanDeEstudio() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del plan de estudio es obligatorio");
        }
        PlanDeEstudio planExistente = planDeEstudioServicio.buscarPlanDeEstudioPorId(carrera.getPlanDeEstudio().getIdPlanDeEstudio())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan de estudio no encontrado"));
        carrera.setPlanDeEstudio(planExistente);
        return this.carreraServicio.guardarCarrera(carrera);
    }

    @PutMapping("/carreras/{id}")
    public Carrera editarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
        logger.info("Editando carrera con ID: " + id);
        carrera.setIdCarrera(id);
        return carreraServicio.guardarCarrera(carrera);
    }

    @DeleteMapping("/carreras/{id}")
    public void eliminarCarrera(@PathVariable Integer id) {
        logger.info("Eliminando carrera con ID: " + id);
        carreraServicio.eliminarCarrera(id);
    }
}