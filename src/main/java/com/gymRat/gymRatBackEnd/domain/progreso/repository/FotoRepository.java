package com.gymRat.gymRatBackEnd.domain.progreso.repository;

import com.gymRat.gymRatBackEnd.domain.progreso.entity.FotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<FotoEntity, Long> {
    List<FotoEntity> findByUsuario_IdUsuarioOrderByFechaDesc(
            Long idUsuario
    );

}