package com.gymRat.gymRatBackEnd.domain.rutinas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_tipo_rutina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoRutinaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_rutina")
    private Long idTipoRutina;


    @Column(nullable = false, length = 100)
    private String nombre;


    @Column(columnDefinition = "TEXT")
    private String descripcion;

}