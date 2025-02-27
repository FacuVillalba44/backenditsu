package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    private Integer notaFinal;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materias materia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
