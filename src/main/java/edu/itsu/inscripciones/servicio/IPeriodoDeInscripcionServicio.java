package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.PeriodoDeInscripcion;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IPeriodoDeInscripcionServicio {
    List<PeriodoDeInscripcion> listarPeriodos();
    Optional<PeriodoDeInscripcion> buscarPorId(Long id);
    PeriodoDeInscripcion guardarPeriodo(PeriodoDeInscripcion periodo);
    void eliminarPeriodo(Long id);
    List<PeriodoDeInscripcion> findPeriodosActivos(LocalDateTime fecha);
}