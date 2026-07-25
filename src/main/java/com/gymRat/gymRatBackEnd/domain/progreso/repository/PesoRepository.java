package com.gymRat.gymRatBackEnd.domain.progreso.repository;

import com.gymRat.gymRatBackEnd.domain.progreso.entity.PesoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PesoRepository extends JpaRepository<PesoEntity, Long> {

    List<PesoEntity> findByUsuario_IdUsuarioOrderByFechaDesc(
            Long idUsuario
    );

}