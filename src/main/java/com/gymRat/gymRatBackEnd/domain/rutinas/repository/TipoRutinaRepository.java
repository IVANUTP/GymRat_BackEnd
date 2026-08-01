package com.gymRat.gymRatBackEnd.domain.rutinas.repository;


import com.gymRat.gymRatBackEnd.domain.rutinas.entity.TipoRutinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRutinaRepository
        extends JpaRepository<TipoRutinaEntity, Long> {


}