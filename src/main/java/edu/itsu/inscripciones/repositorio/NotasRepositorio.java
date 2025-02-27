package edu.itsu.inscripciones.repositorio;
import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.modelo.Notas;
import edu.itsu.inscripciones.modelo.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface NotasRepositorio extends JpaRepository<Notas, Integer> {

    Optional<Notas> findByUsuarioAndMateria(Usuario usuario, Materias materiaCorrelativa);}
