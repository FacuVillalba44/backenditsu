package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.PlanDeEstudio;
import java.util.List;
import java.util.Optional;

public interface IPlanDeEstudioServicio {
    List<PlanDeEstudio> listarTodos();
    PlanDeEstudio guardar(PlanDeEstudio plan);
    Optional<PlanDeEstudio> buscarPlanDeEstudioPorId(Integer id);
    void eliminar(Integer id);
}