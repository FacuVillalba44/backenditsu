package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Notas;
import java.util.List;
import java.util.Optional;

public interface INotasServicio {
    List<Notas> listarNotas();
    Optional<Notas> buscarNotaPorId(Integer id);
    Notas guardarNota(Notas nota);
    void eliminarNota(Integer id);
}