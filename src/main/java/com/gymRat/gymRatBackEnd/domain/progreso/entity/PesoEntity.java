package com.gymRat.gymRatBackEnd.domain.progreso.entity;

import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_peso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PesoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;


    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;


    @Column(nullable = false)
    private LocalDateTime fecha;


    @PrePersist
    public void prePersist(){
        this.fecha = LocalDateTime.now();
    }

}