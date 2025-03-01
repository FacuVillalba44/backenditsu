package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class LlamadosAMesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materias idMateria;

    @Column(nullable = false)
    private LocalDate fechaExamen;

    @Column(nullable = false)
    private String turno; // Ej. "Febrero/Marzo"
}