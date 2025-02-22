package edu.itsu.inscripciones.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import edu.itsu.inscripciones.repositorio.InscripcionesCarrerasRepositorio;

@Service
public class InscripcionesCarrerasServicio implements IInscripcionesCarrerasServicio {
    @Autowired
    private InscripcionesCarrerasRepositorio inscripcionesCarrerasRepositorio;

    @Override
    public List<InscripcionesCarreras> listarInscripciones() {
        return this.inscripcionesCarrerasRepositorio.findAll();
    }

    @Override
    public InscripcionesCarreras buscarInscripcionPorId(Integer id) {
        return this.inscripcionesCarrerasRepositorio.findById(id).orElse(null);
    }

    @Override
    public InscripcionesCarreras guardarInscripcion(InscripcionesCarreras inscripcion) {
        return this.inscripcionesCarrerasRepositorio.save(inscripcion);
    }

    @Override
    public void eliminarInscripcion(Integer id) {
        this.inscripcionesCarrerasRepositorio.deleteById(id);
    }

    @Override
    public List<InscripcionesCarreras> listarPorCarrera(Integer idCarrera) {
        return this.inscripcionesCarrerasRepositorio.findAll()
            .stream()
            .filter(inscripcion -> inscripcion.getCarrera().getIdCarrera().equals(idCarrera))
            .toList();
    }
}