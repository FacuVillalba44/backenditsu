package edu.itsu.inscripciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionesAExamenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_llamado", nullable = false)
    private LlamadosAMesa idLlamado; // Reemplaza idMateria y fechaDeExamen

    private Integer ciclo;

    private Integer anioDeCursado;

    private String condicion;

    private LocalDateTime fechaDeInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'enviada'")
    private String estado;

    @Column(nullable = false)
    private Integer llamado;
}