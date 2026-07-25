package com.gymRat.gymRatBackEnd.domain.rutinas.repository;


import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutinaDetalleRepository
        extends JpaRepository<RutinaDetalleEntity, Long> {


    List<RutinaDetalleEntity> findByRutina_IdRutina(Long idRutina);


    List<RutinaDetalleEntity> findByEjercicio_IdEjercicio(Long idEjercicio);

}