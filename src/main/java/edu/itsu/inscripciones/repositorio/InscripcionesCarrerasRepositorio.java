package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.InscripcionesCarreras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscripcionesCarrerasRepositorio extends JpaRepository<InscripcionesCarreras, Integer> {
    Optional<InscripcionesCarreras> findByUsuarioIdUsuario(Integer idUsuario);
    List<InscripcionesCarreras> findAllByUsuarioIdUsuario(Integer idUsuario);
}