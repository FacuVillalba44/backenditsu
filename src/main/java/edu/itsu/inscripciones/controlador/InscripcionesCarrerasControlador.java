package edu.itsu.inscripciones.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import edu.itsu.inscripciones.servicio.IInscripcionesCarrerasServicio;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class InscripcionesCarrerasControlador {
    private static final Logger logger = LoggerFactory.getLogger(InscripcionesCarrerasControlador.class);

    @Autowired
    private IInscripcionesCarrerasServicio inscripcionesCarrerasServicio;

    @GetMapping("/inscripciones/carrera/{idCarrera}")
    public List<InscripcionesCarreras> obtenerInscriptosPorCarrera(@PathVariable Integer idCarrera) {
        logger.info("Obteniendo inscriptos para la carrera con id: " + idCarrera);
        List<InscripcionesCarreras> inscripciones = inscripcionesCarrerasServicio.listarInscripciones()
            .stream()
            .filter(inscripcion -> inscripcion.getCarrera().getIdCarrera().equals(idCarrera))
            .toList();
        logger.info("Inscripciones encontradas: " + inscripciones.size());
        return inscripciones;
    }
}