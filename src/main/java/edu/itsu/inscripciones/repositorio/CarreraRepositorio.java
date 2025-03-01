package edu.itsu.inscripciones.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itsu.inscripciones.modelo.Carrera;

public interface CarreraRepositorio extends JpaRepository <Carrera,Integer>{
    Optional<Carrera> findById(Integer id);
}
