package edu.itsu.inscripciones.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDeEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlanDeEstudio;

    private String codigoResolucion;

    private String nombre;

    private String descripcion;

    private String linkRecurso;

    private LocalDate fechaEntradaEnVigencia; // Sugerido: Fecha de entrada en vigencia

    private Integer duracionEnAnios; // Sugerido: Duración en años (1-4 típico)
}