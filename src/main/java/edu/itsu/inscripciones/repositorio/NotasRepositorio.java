package edu.itsu.inscripciones.repositorio;
import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.modelo.Notas;
import edu.itsu.inscripciones.modelo.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@SuppressWarnings("unused")
public interface NotasRepositorio extends JpaRepository<Notas, Integer> {

    Optional<Notas> findByUsuarioIdUsuarioAndMateriaIdMateria(Integer idUsuario, Integer idMateria);

}
