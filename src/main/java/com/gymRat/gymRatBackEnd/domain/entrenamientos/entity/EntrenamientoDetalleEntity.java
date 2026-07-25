package com.gymRat.gymRatBackEnd.domain.entrenamientos.entity;

import com.gymRat.gymRatBackEnd.domain.ejercicios.Entity.EjercicioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tbl_entrenamiento_detalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrenamientoDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenamiento", nullable = false)
    private EntrenamientoEntity entrenamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejercicio", nullable = false)
    private EjercicioEntity ejercicio;

    @Column(nullable = false)
    private Integer serie;

    @Column(precision = 6, scale = 2)
    private BigDecimal peso;

    @Column(nullable = false)
    private Integer repeticiones;

    private Integer rir;

}