package edu.itsu.inscripciones.servicio;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import edu.itsu.inscripciones.repositorio.UsuarioRepositorio;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;
import edu.itsu.inscripciones.servicio.IInscripcionesCarrerasServicio;
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
    private IInscripcionesCarrerasServicio inscripcionesCarrerasServicio;
    @Autowired
    private IRolServicio rolServicio;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Usuario> listarUsuario() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return this.usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    public Usuario guardarUsuarioConInscripcion(Usuario usuario, Integer idCarrera) {
        logger.info("Guardando usuario: " + usuario);
        if (usuario.getIdRol() != null) {
            logger.info("Validando rol: " + usuario.getIdRol());
            rolServicio.buscarRolPorId(usuario.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        }
        // Encriptar la clave aquí
        usuario.setClaveAcceso(passwordEncoder.encode(usuario.getClaveAcceso()));
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
            logger.info("Guardando inscripción para usuario " + nuevoUsuario.getIdUsuario() + " y carrera " + idCarrera);
            inscripcionesCarrerasServicio.guardarInscripcion(inscripcion);
            logger.info("Inscripción guardada");
        }

        return nuevoUsuario;
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        this.usuarioRepositorio.deleteById(idUsuario);
    }
}