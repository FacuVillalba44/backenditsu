package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Correlatividades;
import java.util.List;
import java.util.Optional;

public interface ICorrelatividadesServicio {
    List<Correlatividades> listarCorrelatividades();
    Optional<Correlatividades> buscarCorrelatividadPorId(Integer id);
    Correlatividades guardarCorrelatividad(Correlatividades correlatividad);
    void eliminarCorrelatividad(Integer id);
}