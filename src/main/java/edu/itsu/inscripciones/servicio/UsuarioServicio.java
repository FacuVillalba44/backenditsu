package edu.itsu.inscripciones.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.repositorio.UsuarioRepositorio;

@SuppressWarnings("unused")
@Service

public class UsuarioServicio implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public List<Usuario> listarUsuario() {
      
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
   
       Usuario usuario = this.usuarioRepositorio.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        // si no existe el id en la bd ingresa un nuevo registro, si existe, lo actualiza
        return this.usuarioRepositorio.save(usuario);
    }
 
    @Override
    public void eliminarUsuario(Integer idUsuario) {
    
        this.usuarioRepositorio.deleteById(idUsuario);
    }


}
