package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionesAExamenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "catedra", nullable = false)
    private Materias catedra;

    private Integer curso;

    private Integer anioDeCursado;

    private String condicion;

    private LocalDate fechaDeExamen;

    private LocalDate fechaDeInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}