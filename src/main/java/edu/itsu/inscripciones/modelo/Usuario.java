package edu.itsu.inscripciones.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUsuario;
    String nombreUsuario;
    String apellidoUsuario;
    String dniUsuario;
    String domicilioUsuario;
    String telefonoUsuario;
    String emailUsuario;
    Integer idRol;
    String claveAcceso;
    @Transient // No se guarda en la tabla
    private Integer idCarrera; // Para recibir del JSON
    @Transient // No se guarda en la tabla
    private LocalDate fechaInscripcion; // agregue esto
    @Column(name = "estado", columnDefinition = "VARCHAR(20) DEFAULT 'activo'")
    private String estado;
}
