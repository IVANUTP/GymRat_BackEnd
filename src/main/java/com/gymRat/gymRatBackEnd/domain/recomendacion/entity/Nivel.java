package com.gymRat.gymRatBackEnd.domain.recomendacion.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_niveles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nivel {

    @Id
    @Column(name = "id_nivel")
    private Short idNivel;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
}