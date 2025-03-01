package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateria;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_planDeEstudio", nullable = false)
    private PlanDeEstudio planDeEstudio;

    private Integer numeroDeMateria;

    @Column(nullable = false)
    private Integer ciclo;

}
