package com.gymRat.gymRatBackEnd.domain.progreso.entity;

import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_fotos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FotoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;


    @Column(nullable = false, length = 500)
    private String url;


    @Column(nullable = false)
    private LocalDateTime fecha;


    @PrePersist
    public void prePersist(){

        this.fecha = LocalDateTime.now();

    }

}