package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Carrera;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarreraServicioTest {

    @Mock
    private CarreraRepositorio carreraRepositorio;

    @InjectMocks
    private CarreraServicio carreraServicio;

    @Test
    void testListarCarrera() {
        // Verifica que el método devuelve una lista de carreras mockeadas desde findAll().
        Carrera carrera1 = new Carrera();
        carrera1.setIdCarrera(1);
        carrera1.setNombreCarrera("Ingeniería");

        Carrera carrera2 = new Carrera();
        carrera2.setIdCarrera(2);
        carrera2.setNombreCarrera("Medicina");

        List<Carrera> carrerasEsperadas = Arrays.asList(carrera1, carrera2);
        when(carreraRepositorio.findAll()).thenReturn(carrerasEsperadas);

        // Act
        List<Carrera> resultado = carreraServicio.listarCarrera();

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Ingeniería", resultado.get(0).getNombreCarrera());
        assertEquals("Medicina", resultado.get(1).getNombreCarrera());
        verify(carreraRepositorio, times(1)).findAll();
    }

    @Test
    void testBuscarCarreraPorId_Existente() {
        // Comprueba que devuelve un Optional con la carrera cuando existe.
        Carrera carrera = new Carrera();
        carrera.setIdCarrera(1);
        carrera.setNombreCarrera("Ingeniería");
        when(carreraRepositorio.findById(1)).thenReturn(Optional.of(carrera));

        // Act
        Optional<Carrera> resultado = carreraServicio.buscarCarreraPorId(1);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Ingeniería", resultado.get().getNombreCarrera());
        verify(carreraRepositorio, times(1)).findById(1);
    }

    @Test
    void testBuscarCarreraPorId_NoExistente() {
        // Asegura que devuelve un Optional vacío cuando no hay carrera.
        when(carreraRepositorio.findById(999)).thenReturn(Optional.empty());

        // Act
        Optional<Carrera> resultado = carreraServicio.buscarCarreraPorId(999);

        // Assert
        assertFalse(resultado.isPresent());
        verify(carreraRepositorio, times(1)).findById(999);
    }

    @Test
    void testGuardarCarrera_Crear() {
        // Simula la creación de una carrera nueva (sin ID inicial) y verifica que se asigna un ID.
        Carrera carrera = new Carrera();
        carrera.setNombreCarrera("Ingeniería");

        Carrera carreraGuardada = new Carrera();
        carreraGuardada.setIdCarrera(1);
        carreraGuardada.setNombreCarrera("Ingeniería");

        when(carreraRepositorio.save(any(Carrera.class))).thenReturn(carreraGuardada);

        // Act
        Carrera resultado = carreraServicio.guardarCarrera(carrera);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdCarrera());
        assertEquals("Ingeniería", resultado.getNombreCarrera());
        verify(carreraRepositorio, times(1)).save(carrera);
    }

    @Test
    void testGuardarCarrera_Actualizar() {
        // Simula la actualización de una carrera existente (con ID) y verifica los datos.
        Carrera carrera = new Carrera();
        carrera.setIdCarrera(1);
        carrera.setNombreCarrera("Ingeniería Actualizada");

        when(carreraRepositorio.save(any(Carrera.class))).thenReturn(carrera);

        // Act
        Carrera resultado = carreraServicio.guardarCarrera(carrera);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdCarrera());
        assertEquals("Ingeniería Actualizada", resultado.getNombreCarrera());
        verify(carreraRepositorio, times(1)).save(carrera);
    }

    @Test
    void testEliminarCarrera() {
        // Confirma que se llama a deleteById() con el ID correcto.
        Integer idCarrera = 1;
        doNothing().when(carreraRepositorio).deleteById(idCarrera);

        // Act
        carreraServicio.eliminarCarrera(idCarrera);

        // Assert
        verify(carreraRepositorio, times(1)).deleteById(idCarrera);
    }
}