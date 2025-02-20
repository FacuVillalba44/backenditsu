package edu.itsu.inscripciones.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;

import java.util.List;

 
@Service
public class CarreraServicio implements ICarreraServicio{
    
    @Autowired 
    private CarreraRepositorio carreraRepositorio;
        
    @Override
    public List<Carrera> listarCarrera() {
        return this.carreraRepositorio.findAll();
    }

    @Override
    public Carrera buscarCarreraPorId(Integer id) {
       Carrera carrera = this.carreraRepositorio.findById(id).orElse(null);
        return carrera;
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        return this.carreraRepositorio.save(carrera);
        //si id=null -> guardar
        //si id!=null -> actualizar
    }

    @Override
    public void eliminarCarrera(Integer idCarrera) {
        this.carreraRepositorio.deleteById(idCarrera);
    }

}
