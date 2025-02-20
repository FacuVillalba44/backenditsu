package edu.itsu.inscripciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itsu.inscripciones.Modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

}
