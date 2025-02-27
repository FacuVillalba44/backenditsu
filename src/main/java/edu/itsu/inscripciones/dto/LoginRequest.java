package edu.itsu.inscripciones.dto;
import lombok.Data;

@Data
public class LoginRequest {
    private String emailUsuario;
    private String claveAcceso;
}
