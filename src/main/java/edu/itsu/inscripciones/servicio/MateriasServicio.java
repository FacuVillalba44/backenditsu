package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.repositorio.MateriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriasServicio implements IMateriasServicio {
    @Autowired
    private MateriasRepositorio repositorio;

    public List<Materias> listarMaterias() {
        return repositorio.findAll();
    }

    public Optional<Materias> buscarMateriaPorId(Integer id) {
        return repositorio.findById(id);
    }

    public Materias guardarMateria(Materias materia) {
        return repositorio.save(materia);
    }

    public void eliminarMateria(Integer id) {
        repositorio.deleteById(id);
    }
}