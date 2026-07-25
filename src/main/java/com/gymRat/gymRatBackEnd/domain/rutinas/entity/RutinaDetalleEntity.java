package com.gymRat.gymRatBackEnd.domain.rutinas.entity;

import com.gymRat.gymRatBackEnd.domain.ejercicios.Entity.EjercicioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_rutina_detalle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutinaDetalleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rutina", nullable = false)
    private RutinaEntity rutina;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejercicio", nullable = false)
    private EjercicioEntity ejercicio;


    @Column(nullable = false)
    private Integer series;


    @Column(nullable = false)
    private Integer repeticiones;


    private Integer descanso;


    @Column(nullable = false)
    private Integer orden;

}