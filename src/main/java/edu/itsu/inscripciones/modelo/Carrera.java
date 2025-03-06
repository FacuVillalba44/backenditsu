package edu.itsu.inscripciones.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrera;

    private String nombreCarrera;

    @ManyToOne
    @JoinColumn(name = "id_planDeEstudio", nullable = false)
    private PlanDeEstudio planDeEstudio; // Renombrado de resolucionCarrera

    private LocalDate inicioDeDictado; // Añadido para fecha de inicio
}