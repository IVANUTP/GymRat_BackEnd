package com.gymRat.gymRatBackEnd.domain.entrenamientos.entity;

import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_entrenamientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrenamientoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenamiento")
    private Long idEntrenamiento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rutina")
    private RutinaEntity rutina;


    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;


    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;


    @Column(name = "duracion")
    private Integer duracion;


    @Column(name = "volumen_total", precision = 10, scale = 2)
    private BigDecimal volumenTotal;


    @PrePersist
    public void prePersist(){
        if(fechaInicio == null){
            fechaInicio = LocalDateTime.now();
        }
    }

}