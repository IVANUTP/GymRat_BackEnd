package com.gymRat.gymRatBackEnd.domain.objetivo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_objetivos_rutina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjetivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Long idObjetivo;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

}