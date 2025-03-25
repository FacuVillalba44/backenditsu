package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.PlanDeEstudio;
import edu.itsu.inscripciones.repositorio.PlanDeEstudioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanDeEstudioServicio implements IPlanDeEstudioServicio {
    @Autowired
    private PlanDeEstudioRepositorio repositorio;

    public List<PlanDeEstudio> listarTodos() {
        return repositorio.findAll();
    }

    public PlanDeEstudio guardar(PlanDeEstudio plan) {
        return repositorio.save(plan);
    }

    public Optional<PlanDeEstudio> buscarPlanDeEstudioPorId(Integer id) {  // Renombrado para consistencia con el controlador
        return repositorio.findById(id);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}