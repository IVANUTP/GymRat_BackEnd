package com.gymRat.gymRatBackEnd.domain.recomendacion.entity;

import com.gymRat.gymRatBackEnd.domain.objetivo.ObjetivoEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.TipoRutinaEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_recomendacion_rutina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecomendacionRutina {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion")
    private Long idRecomendacion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_objetivo")
    private ObjetivoEntity objetivo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_rutina")
    private TipoRutinaEntity tipoRutina;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;


    @Column(name = "dias_min")
    private Short diasMin;


    @Column(name = "dias_max")
    private Short diasMax;


    @Column(name = "prioridad")
    private Short prioridad;
}