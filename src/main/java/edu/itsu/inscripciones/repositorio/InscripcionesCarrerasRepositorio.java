package edu.itsu.inscripciones.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.itsu.inscripciones.modelo.InscripcionesCarreras;

public interface InscripcionesCarrerasRepositorio extends JpaRepository<InscripcionesCarreras, Integer> {
}