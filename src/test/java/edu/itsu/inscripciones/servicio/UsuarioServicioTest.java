package edu.itsu.inscripciones.servicio;

import edu.itsu.inscripciones.modelo.Usuario;
import edu.itsu.inscripciones.repositorio.UsuarioRepositorio;
import edu.itsu.inscripciones.repositorio.CarreraRepositorio;
import edu.itsu.inscripciones.repositorio.InscripcionesCarrerasRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServicioTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @Mock
    private CarreraRepositorio carreraRepositorio;

    @Mock
    private InscripcionesCarrerasRepositorio inscripcionesCarrerasRepositorio;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private UsuarioServicio usuarioServicio;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        usuarioServicio = new UsuarioServicio();
        // Inyectar el mock manualmente en el campo privado
        Field passwordEncoderField = UsuarioServicio.class.getDeclaredField("passwordEncoder");
        passwordEncoderField.setAccessible(true);
        passwordEncoderField.set(usuarioServicio, passwordEncoder);

        // Inyectar otros mocks (si son necesarios por otros métodos)
        Field usuarioRepositorioField = UsuarioServicio.class.getDeclaredField("usuarioRepositorio");
        usuarioRepositorioField.setAccessible(true);
        usuarioRepositorioField.set(usuarioServicio, usuarioRepositorio);

        Field carreraRepositorioField = UsuarioServicio.class.getDeclaredField("carreraRepositorio");
        carreraRepositorioField.setAccessible(true);
        carreraRepositorioField.set(usuarioServicio, carreraRepositorio);

        Field inscripcionesCarrerasRepositorioField = UsuarioServicio.class.getDeclaredField("inscripcionesCarrerasRepositorio");
        inscripcionesCarrerasRepositorioField.setAccessible(true);
        inscripcionesCarrerasRepositorioField.set(usuarioServicio, inscripcionesCarrerasRepositorio);
    }

    @Test
    void testGuardarUsuarioNuevoSinClaveAcceso() {
        // Prueba la creación de un nuevo usuario cuando no se proporciona claveAcceso, 
        //usando dniUsuario como valor por defecto para encriptar.
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Juan");
        usuario.setApellidoUsuario("Pérez");
        usuario.setDniUsuario("12345678");
        usuario.setEmailUsuario("juan@example.com");

        String hashMockeado = "$2a$10$Hq6Jk5GmweGHoDNdwXyJPuYTtgIR3EKBk7yoKHg6GBK5rG1qCZ3xe";
        when(passwordEncoder.encode("12345678")).thenReturn(hashMockeado);
        when(usuarioRepositorio.save(any(Usuario.class))).thenAnswer(invocation -> {
            Usuario u = invocation.getArgument(0);
            u.setIdUsuario(1); // Simulamos que save asigna un ID
            return u;
        });

        // Act
        Usuario resultado = usuarioServicio.guardarUsuarioConInscripcion(usuario, null);

        // Assert
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombreUsuario());
        assertEquals("Pérez", resultado.getApellidoUsuario());
        assertEquals("12345678", resultado.getDniUsuario());
        assertEquals(hashMockeado, resultado.getClaveAcceso()); // Verificamos el hash exacto
        assertEquals("activo", resultado.getEstado());
        assertEquals(1, resultado.getIdRol());
        verify(usuarioRepositorio, times(1)).save(any(Usuario.class));
        verify(passwordEncoder, times(1)).encode("12345678");
        verifyNoInteractions(carreraRepositorio, inscripcionesCarrerasRepositorio);
    }

    @Test
    void testActualizarUsuarioSinCambiarClave() {
        // Prueba la actualización de un usuario existente
        //preservando la claveAcceso original cuando no se envía una nueva.
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setIdUsuario(1);
        usuarioExistente.setNombreUsuario("Juan");
        usuarioExistente.setApellidoUsuario("Pérez");
        usuarioExistente.setDniUsuario("12345678");
        usuarioExistente.setEmailUsuario("juan@example.com");
        usuarioExistente.setClaveAcceso("$2a$10$abcdef1234567890abcdef1234567890abcdef1234567890abcde");
        usuarioExistente.setEstado("activo");
        usuarioExistente.setIdRol(1);

        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setIdUsuario(1);
        usuarioActualizado.setNombreUsuario("Juan Actualizado");

        when(usuarioRepositorio.findById(1)).thenReturn(java.util.Optional.of(usuarioExistente));
        when(usuarioRepositorio.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Usuario resultado = usuarioServicio.guardarUsuarioConInscripcion(usuarioActualizado, null);

        // Assert
        assertNotNull(resultado);
        assertEquals("Juan Actualizado", resultado.getNombreUsuario());
        assertEquals("Pérez", resultado.getApellidoUsuario());
        assertEquals("$2a$10$abcdef1234567890abcdef1234567890abcdef1234567890abcde", resultado.getClaveAcceso());
        verify(usuarioRepositorio, times(1)).findById(1);
        verify(usuarioRepositorio, times(1)).save(any(Usuario.class));
        verifyNoInteractions(passwordEncoder, carreraRepositorio, inscripcionesCarrerasRepositorio);
    }
}