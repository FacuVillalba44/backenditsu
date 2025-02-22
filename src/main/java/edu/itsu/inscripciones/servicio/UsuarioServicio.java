package edu.itsu.inscripciones.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import edu.itsu.inscripciones.repositorio.UsuarioRepositorio;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;
import edu.itsu.inscripciones.servicio.IInscripcionesCarrerasServicio;

@SuppressWarnings("unused")
@Service
public class UsuarioServicio implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CarreraRepositorio carreraRepositorio;
    @Autowired
    private IInscripcionesCarrerasServicio inscripcionesCarrerasServicio;

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

    // Nuevo método para manejar el JSON con idCarrera
    public Usuario guardarUsuarioConInscripcion(Usuario usuario, Integer idCarrera) {
        // Guardar el usuario primero
        Usuario nuevoUsuario = this.usuarioRepositorio.save(usuario);

        // Si viene idCarrera, crear la inscripción
        if (idCarrera != null) {
            Carrera carrera = carreraRepositorio.findById(idCarrera)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
            InscripcionesCarreras inscripcion = new InscripcionesCarreras();
            inscripcion.setUsuario(nuevoUsuario);
            inscripcion.setCarrera(carrera);
            inscripcionesCarrerasServicio.guardarInscripcion(inscripcion);
        }

        return nuevoUsuario;
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        this.usuarioRepositorio.deleteById(idUsuario);
    }
}