package edu.itsu.inscripciones.servicio;

import java.util.List;
import java.util.Optional;

import edu.itsu.inscripciones.modelo.Rol;

public interface IRolServicio {
    List<Rol> listarRoles();
    Optional<Rol> buscarRolPorId(Integer id);
    Rol guardarRol(Rol rol);
    void eliminarRol(Integer id);
}
