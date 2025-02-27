package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Notas;
import edu.itsu.inscripciones.repositorio.NotasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotasServicio implements INotasServicio {
    @Autowired
    private NotasRepositorio repositorio;

    public List<Notas> listarNotas() {
        return repositorio.findAll();
    }

    public Optional<Notas> buscarNotaPorId(Integer id) {
        return repositorio.findById(id);
    }

    public Notas guardarNota(Notas nota) {
        return repositorio.save(nota);
    }

    public void eliminarNota(Integer id) {
        repositorio.deleteById(id);
    }
}
