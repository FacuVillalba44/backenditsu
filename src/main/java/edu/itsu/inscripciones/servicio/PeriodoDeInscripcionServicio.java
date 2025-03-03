package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.PeriodoDeInscripcion;
import edu.itsu.inscripciones.repositorio.PeriodoDeInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodoDeInscripcionServicio implements IPeriodoDeInscripcionServicio {
    @Autowired
    private PeriodoDeInscripcionRepositorio repositorio;

    @Override
    public List<PeriodoDeInscripcion> listarPeriodos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<PeriodoDeInscripcion> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public PeriodoDeInscripcion guardarPeriodo(PeriodoDeInscripcion periodo) {
        return repositorio.save(periodo);
    }

    @Override
    public void eliminarPeriodo(Long id) {
        repositorio.deleteById(id);
    }

    public List<PeriodoDeInscripcion> findPeriodosActivos(LocalDateTime fecha) {
        return repositorio.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(fecha, fecha);
    }
}