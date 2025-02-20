package edu.itsu.inscripciones.servicio;
import java.util.List;

import edu.itsu.inscripciones.modelo.Carrera;

public interface ICarreraServicio {
    public List<Carrera> listarCarrera();
    public Carrera buscarCarreraPorId(Integer id);
    //Carrera =  tipo de objeto que se va a guardar y carrera = valor que se va a guardar 
    public Carrera guardarCarrera(Carrera carrera); 
    public void eliminarCarrera(Integer idCarrera);
}