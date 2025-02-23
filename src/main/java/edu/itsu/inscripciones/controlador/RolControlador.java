package edu.itsu.inscripciones.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.itsu.inscripciones.modelo.Rol;
import edu.itsu.inscripciones.servicio.IRolServicio;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class RolControlador {
    private static final Logger logger = LoggerFactory.getLogger(RolControlador.class);

    @Autowired
    private IRolServicio rolServicio;

    @GetMapping("/roles")
    public List<Rol> obtenerRoles() {
        List<Rol> roles = rolServicio.listarRoles();
        logger.info("Obteniendo lista de roles");
        roles.forEach(rol -> logger.info(rol.toString()));
        return roles;
    }

    @PostMapping("/roles")
    public Rol agregarRol(@RequestBody Rol rol) {
        logger.info("Rol a agregar: " + rol);
        return rolServicio.guardarRol(rol);
    }
}