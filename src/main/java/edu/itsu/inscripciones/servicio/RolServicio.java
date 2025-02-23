package edu.itsu.inscripciones.servicio;

import java.util.List;
import java.util.Optional; // Añadir este import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.itsu.inscripciones.modelo.Rol;
import edu.itsu.inscripciones.repositorio.RolRepositorio;

@Service
public class RolServicio implements IRolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public List<Rol> listarRoles() {
        return this.rolRepositorio.findAll();
    }

    @Override
    public Optional<Rol> buscarRolPorId(Integer id) {
        return this.rolRepositorio.findById(id); // Devuelve Optional<Rol>
    }

    @Override
    public Rol guardarRol(Rol rol) {
        return this.rolRepositorio.save(rol);
    }

    @Override
    public void eliminarRol(Integer id) {
        this.rolRepositorio.deleteById(id);
    }
}