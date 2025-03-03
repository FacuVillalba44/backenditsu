package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.LlamadosAMesa;
import edu.itsu.inscripciones.modelo.Materias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LlamadosAMesaRepositorio extends JpaRepository<LlamadosAMesa, Long> {
    List<LlamadosAMesa> findByIdMateria(Materias idMateria);
}