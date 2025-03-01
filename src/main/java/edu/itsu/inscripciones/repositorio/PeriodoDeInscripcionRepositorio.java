package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.PeriodoDeInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface PeriodoDeInscripcionRepositorio extends JpaRepository<PeriodoDeInscripcion, Long> {
    List<PeriodoDeInscripcion> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDateTime fecha, LocalDateTime fecha2);
}