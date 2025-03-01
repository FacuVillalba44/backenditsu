package edu.itsu.inscripciones.servicio;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;//se usa para encriptar la contraseña antes de guardarla en la base de datos
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import edu.itsu.inscripciones.repositorio.UsuarioRepositorio;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;
import edu.itsu.inscripciones.repositorio.InscripcionesCarrerasRepositorio; // Asegúrate de tener este import
import edu.itsu.inscripciones.servicio.IRolServicio;

@SuppressWarnings("unused")
@Service
public class UsuarioServicio implements IUsuarioServicio {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CarreraRepositorio carreraRepositorio;
    @Autowired
    private InscripcionesCarrerasRepositorio inscripcionesCarrerasRepositorio; // Inyectado aquí
    @Autowired
    private IRolServicio rolServicio;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Usuario> listarUsuario() {
        return this.usuarioRepositorio.findAll();
    }

    public List<Usuario> listarAlumnosPorRol(Integer idRol) {
        return this.usuarioRepositorio.findAll().stream()
                .filter(usuario -> usuario.getIdRol() != null && usuario.getIdRol().equals(idRol))
                .toList();
    }

    public List<Usuario> listarAlumnosActivos() {
        return usuarioRepositorio.findByIdRolAndEstado(1, "activo");
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return this.usuarioRepositorio.findAll().stream()
                .filter(u -> u.getEmailUsuario().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        Usuario usuario = this.usuarioRepositorio.findById(id).orElse(null);
        if (usuario != null) {
            InscripcionesCarreras inscripcion = inscripcionesCarrerasRepositorio.findAll().stream()
                    .filter(i -> i.getUsuario().getIdUsuario().equals(id))
                    .findFirst()
                    .orElse(null);
            if (inscripcion != null) {
                usuario.setIdCarrera(inscripcion.getCarrera().getIdCarrera());
            }
        }
        return usuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    public Usuario guardarUsuarioConInscripcion(Usuario usuario, Integer idCarrera) {
        logger.info("Guardando usuario: " + usuario);
        usuario.setIdRol(1); // Asignamos rol de alumno automáticamente
        usuario.setClaveAcceso(passwordEncoder.encode(usuario.getClaveAcceso()));
        usuario.setEstado("activo"); // Estado activo
        Usuario nuevoUsuario = this.usuarioRepositorio.save(usuario);
        logger.info("Usuario guardado con ID: " + nuevoUsuario.getIdUsuario());
    
        if (idCarrera != null) {
            logger.info("Buscando carrera con ID: " + idCarrera);
            Carrera carrera = carreraRepositorio.findById(idCarrera)
                    .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
            logger.info("Carrera encontrada: " + carrera.getNombreCarrera());
            InscripcionesCarreras inscripcion = new InscripcionesCarreras();
            inscripcion.setUsuario(nuevoUsuario);
            inscripcion.setCarrera(carrera);
            inscripcion.setFechaInscripcion(usuario.getFechaInscripcion());
            logger.info("Guardando inscripción para usuario " + nuevoUsuario.getIdUsuario() + " y carrera " + idCarrera);
            inscripcionesCarrerasRepositorio.save(inscripcion);
            logger.info("Inscripción guardada");
        }
    
        return nuevoUsuario;
    }
    /*------Metodo para borrar completamente el usuario
    @Override
    public void eliminarUsuario(Integer idUsuario) {
        // Primero eliminamos las inscripciones asociadas
        List<InscripcionesCarreras> inscripciones = inscripcionesCarrerasRepositorio.findAll().stream()
                .filter(i -> i.getUsuario().getIdUsuario().equals(idUsuario))
                .collect(Collectors.toList());
        for (InscripcionesCarreras inscripcion : inscripciones) {
            inscripcionesCarrerasRepositorio.delete(inscripcion);
        }
        // Luego eliminamos el usuario
        this.usuarioRepositorio.deleteById(idUsuario);
    }*/

    public void marcarComoInactivo(Integer idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstado("inactivo");
        usuarioRepositorio.save(usuario);
    }
}