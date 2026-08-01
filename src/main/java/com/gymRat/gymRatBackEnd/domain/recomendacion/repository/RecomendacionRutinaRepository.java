package com.gymRat.gymRatBackEnd.domain.recomendacion.repository;

import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.RecomendacionRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecomendacionRutinaRepository
        extends JpaRepository<RecomendacionRutina, Long> {

    Optional<RecomendacionRutina> findFirstByObjetivo_IdObjetivoAndNivel_IdNivelAndDiasMinLessThanEqualAndDiasMaxGreaterThanEqualOrderByPrioridadDesc(
            Long idObjetivo, Short idNivel, Short dias1, Short dias2
    );
}