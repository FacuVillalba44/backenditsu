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


public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCarrera;
    String nombreCarrera;
    String duracionCarrera;
    String descripcionCarrera;
    String resolucionCarrera;
}