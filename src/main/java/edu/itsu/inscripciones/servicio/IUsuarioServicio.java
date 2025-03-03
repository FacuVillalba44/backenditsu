package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Usuario;
import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuario();

    public Usuario buscarUsuarioPorId(Integer id);

    // Usuario = tipo de objeto que se va a guardar y usuario = valor que se va a
    // guardar
    public Usuario guardarUsuario(Usuario usuario);

    /* public void eliminarUsuario(Integer idUsuario); */
    public void marcarComoInactivo(Integer idUsuario);

    public List<Usuario> listarAlumnosActivos();

}
