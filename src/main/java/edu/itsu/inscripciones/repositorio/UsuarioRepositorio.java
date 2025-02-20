package edu.itsu.inscripciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itsu.inscripciones.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

}
