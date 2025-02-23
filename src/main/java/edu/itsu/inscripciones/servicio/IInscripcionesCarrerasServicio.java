package edu.itsu.inscripciones.servicio;

import java.util.List;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;

public interface IInscripcionesCarrerasServicio {
    List<InscripcionesCarreras> listarInscripciones();
    InscripcionesCarreras buscarInscripcionPorId(Integer id);
    InscripcionesCarreras guardarInscripcion(InscripcionesCarreras inscripcion);
    void eliminarInscripcion(Integer id);
    List<InscripcionesCarreras> listarPorCarrera(Integer idCarrera); // Nuevo método
}
