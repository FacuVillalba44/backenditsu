package edu.itsu.inscripciones.controlador;

import org.springframework.web.bind.annotation.RestController;

import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.servicio.UsuarioServicio;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@RestController

// context-path = http://localhost:8080/itsuapi/ <- se vería así el url de la
// api
@RequestMapping("/itsuapi")
// Puerto desde donde recibira las peticiones del front
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")

public class UsuarioControlador {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private UsuarioServicio usuarioServicio;

    // url donde se conectara es http://localhost:8080/api-itsu/usuarios

    @GetMapping("/usuarios") // metodo para listar los usuarios

    public List<Usuario> obtenerUsuario() {
        List<Usuario> usuarios = this.usuarioServicio.listarUsuario();
        logger.info("Obteniendo la lista de usuarios");
        usuarios.forEach(usuario -> logger.info(usuario.toString()));
        return usuarios;
    }

    @PostMapping("/usuarios")
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        logger.info("Usuario a agregar: " + usuario);
        // Asumimos que el JSON incluye "idCarrera" como campo extra
        Integer idCarrera = usuario.getIdCarrera(); // Temporalmente en Usuario.java
        return this.usuarioServicio.guardarUsuarioConInscripcion(usuario, idCarrera);
    }

}
