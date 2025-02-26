package edu.itsu.inscripciones.servicio;
import java.util.List;
import java.util.Optional;

import edu.itsu.inscripciones.modelo.Carrera;

public interface ICarreraServicio {
    public List<Carrera> listarCarrera();
    public Optional<Carrera> buscarCarreraPorId(Integer id);
  
    public Carrera guardarCarrera(Carrera carrera); 
    public void eliminarCarrera(Integer idCarrera);
}