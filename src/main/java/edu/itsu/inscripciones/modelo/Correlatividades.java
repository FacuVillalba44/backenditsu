package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Correlatividades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorrelatividad;

    @ManyToOne
    @JoinColumn(name = "id_Materia", nullable = false)
    private Materias materia;

    @ManyToOne
    @JoinColumn(name = "id_Materia_correlativa", nullable = false)
    private Materias materiaCorrelativa;
}