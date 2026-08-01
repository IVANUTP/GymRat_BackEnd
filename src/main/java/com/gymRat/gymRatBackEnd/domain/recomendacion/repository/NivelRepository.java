package com.gymRat.gymRatBackEnd.domain.recomendacion.repository;

import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Short> {

}