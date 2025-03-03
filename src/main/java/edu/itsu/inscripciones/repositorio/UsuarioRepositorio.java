package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailUsuario(String email);
    List<Usuario> findByIdRolAndEstado(Integer idRol, String estado);
}