package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Materias;
import java.util.List;
import java.util.Optional;

public interface IMateriasServicio {
    List<Materias> listarMaterias();
    Optional<Materias> buscarMateriaPorId(Integer id);
    Materias guardarMateria(Materias materia);
    void eliminarMateria(Integer id);
}