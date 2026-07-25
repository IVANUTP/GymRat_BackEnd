package com.gymRat.gymRatBackEnd.domain.entrenamientos.repository;


import com.gymRat.gymRatBackEnd.domain.entrenamientos.entity.EntrenamientoDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntrenamientoDetalleRepository
        extends JpaRepository<EntrenamientoDetalleEntity, Long> {


    List<EntrenamientoDetalleEntity>
    findByEntrenamiento_IdEntrenamiento(Long idEntrenamiento);



    List<EntrenamientoDetalleEntity>
    findByEjercicio_IdEjercicio(Long idEjercicio);

}