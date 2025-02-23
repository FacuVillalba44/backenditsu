package edu.itsu.inscripciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.itsu.inscripciones.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
}