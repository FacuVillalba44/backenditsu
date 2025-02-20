package edu.itsu.inscripciones.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}