package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.InscripcionesAExamenes;
import java.util.List;
import java.util.Optional;

public interface IInscripcionesAExamenesServicio {
    List<InscripcionesAExamenes> listarInscripciones();
    Optional<InscripcionesAExamenes> buscarPorId(Long id);
    InscripcionesAExamenes guardarInscripcion(InscripcionesAExamenes inscripcion);
    void eliminarInscripcion(Long id);
}