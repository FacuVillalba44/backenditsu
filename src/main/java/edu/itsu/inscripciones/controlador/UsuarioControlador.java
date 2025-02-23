package edu.itsu.inscripciones.controlador;

import org.springframework.web.bind.annotation.RestController;
import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.servicio.UsuarioServicio;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/itsuapi")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev", 
             methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }) // Especificamos métodos permitidos
public class UsuarioControlador {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuario() {
        List<Usuario> usuarios = this.usuarioServicio.listarUsuario();
        logger.info("Obteniendo la lista de usuarios");
        usuarios.forEach(usuario -> logger.info(usuario.toString()));
        return usuarios;
    }

    @GetMapping("/alumnos")
    public List<Usuario> obtenerAlumnos() {
        logger.info("Obteniendo la lista de alumnos (idRol=1)");
        List<Usuario> alumnos = this.usuarioServicio.listarAlumnosPorRol(1);
        alumnos.forEach(alumno -> logger.info(alumno.toString()));
        return alumnos;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Integer id) {
        logger.info("Obteniendo usuario con ID: " + id);
        return this.usuarioServicio.buscarUsuarioPorId(id);
    }

    @PostMapping("/usuarios")
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        logger.info("Usuario a agregar: " + usuario);
        Integer idCarrera = null;
        try {
            idCarrera = usuario.getIdCarrera() != null ? Integer.valueOf(usuario.getIdCarrera()) : null;
        } catch (NumberFormatException e) {
            logger.error("Error al convertir idCarrera: " + usuario.getIdCarrera());
        }
        return this.usuarioServicio.guardarUsuarioConInscripcion(usuario, idCarrera);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        logger.info("Actualizando usuario con ID: " + id);
        usuario.setIdUsuario(id);
        return this.usuarioServicio.guardarUsuarioConInscripcion(usuario, usuario.getIdCarrera());
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        logger.info("Eliminando usuario con ID: " + id);
        this.usuarioServicio.eliminarUsuario(id);
    }
}