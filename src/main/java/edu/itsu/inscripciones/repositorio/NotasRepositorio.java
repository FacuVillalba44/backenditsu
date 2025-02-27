package edu.itsu.inscripciones.repositorio;
import edu.itsu.inscripciones.modelo.Notas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepositorio extends JpaRepository<Notas, Integer> {}
