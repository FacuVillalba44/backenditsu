package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.LlamadosAMesa;
import edu.itsu.inscripciones.modelo.Materias;
import edu.itsu.inscripciones.repositorio.LlamadosAMesaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LlamadosAMesaServicio implements ILlamadosAMesaServicio {
    @Autowired
    private LlamadosAMesaRepositorio repositorio;

    @Override
    public List<LlamadosAMesa> listarLlamados() {
        return repositorio.findAll();
    }

    @Override
    public Optional<LlamadosAMesa> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public LlamadosAMesa guardarLlamado(LlamadosAMesa llamado) {
        return repositorio.save(llamado);
    }

    @Override
    public void eliminarLlamado(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<LlamadosAMesa> findByIdMateria(Materias idMateria) {
        return repositorio.findByIdMateria(idMateria);
    }
}