package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.LlamadosAMesa;
import edu.itsu.inscripciones.modelo.Materias;
import java.util.List;
import java.util.Optional;

public interface ILlamadosAMesaServicio {
    List<LlamadosAMesa> listarLlamados();
    Optional<LlamadosAMesa> buscarPorId(Long id);
    LlamadosAMesa guardarLlamado(LlamadosAMesa llamado);
    void eliminarLlamado(Long id);
    List<LlamadosAMesa> findByIdMateria(Materias idMateria);
}