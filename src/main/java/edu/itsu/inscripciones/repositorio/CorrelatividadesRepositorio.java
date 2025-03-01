package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.Correlatividades;
import edu.itsu.inscripciones.modelo.Materias;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrelatividadesRepositorio extends JpaRepository<Correlatividades, Integer> {

    List<Correlatividades> findByMateria(Materias materia);
    
}