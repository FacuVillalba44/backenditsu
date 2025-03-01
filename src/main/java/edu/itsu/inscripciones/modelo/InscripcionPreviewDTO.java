package edu.itsu.inscripciones.modelo;

import lombok.Data;
import java.time.LocalDate;

@Data
public class InscripcionPreviewDTO {
    private String nombreUsuario;    // Pre-cargado, no editable
    private String apellidoUsuario;  // Pre-cargado, no editable
    private String dniUsuario;       // Pre-cargado, no editable
    private String nombreCarrera;    // Pre-cargado, no editable
    private String nombreMateria;    // Pre-cargado, no editable
    private Integer ciclo;           // Pre-cargado, no editable
    private LocalDate fechaExamen;   // Pre-cargado, no editable
    private Integer anioDeCursado;   // Editable por el alumno
    private String condicion;        // Editable por el alumno
}