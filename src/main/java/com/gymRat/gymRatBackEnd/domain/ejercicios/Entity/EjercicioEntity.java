package com.gymRat.gymRatBackEnd.domain.ejercicios.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_ejercicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EjercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Long idEjercicio;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "grupo_muscular", nullable = false, length = 100)
    private String grupoMuscular;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "imagen", length = 500)
    private String imagen;

    @Column(name = "gif", length = 500)
    private String gif;

    @Column(name = "equipo", length = 100)
    private String equipo;

    @Column(name = "dificultad", length = 50)
    private String dificultad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "activo")
    private Boolean activo;
}