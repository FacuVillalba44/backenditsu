package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Correlatividades;
import edu.itsu.inscripciones.repositorio.CorrelatividadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorrelatividadesServicio implements ICorrelatividadesServicio {
    @Autowired
    private CorrelatividadesRepositorio repositorio;

    public List<Correlatividades> listarCorrelatividades() {
        return repositorio.findAll();
    }

    public Optional<Correlatividades> buscarCorrelatividadPorId(Integer id) {
        return repositorio.findById(id);
    }

    public Correlatividades guardarCorrelatividad(Correlatividades correlatividad) {
        return repositorio.save(correlatividad);
    }

    public void eliminarCorrelatividad(Integer id) {
        repositorio.deleteById(id);
    }
}