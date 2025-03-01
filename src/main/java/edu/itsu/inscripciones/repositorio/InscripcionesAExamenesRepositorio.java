package edu.itsu.inscripciones.repositorio;

import edu.itsu.inscripciones.modelo.InscripcionesAExamenes;
import edu.itsu.inscripciones.modelo.LlamadosAMesa;
import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SuppressWarnings("unused")
public interface InscripcionesAExamenesRepositorio extends JpaRepository<InscripcionesAExamenes, Long> {
    List<InscripcionesAExamenes> findByUsuarioAndIdLlamadoIdMateria(Usuario usuario, Materias idMateria);
}