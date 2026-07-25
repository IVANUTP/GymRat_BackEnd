package com.gymRat.gymRatBackEnd.domain.ejercicios.repository;

import com.gymRat.gymRatBackEnd.domain.ejercicios.Entity.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Long> {

    List<EjercicioEntity> findByGrupoMuscular(String grupoMuscular);

    List<EjercicioEntity> findByActivoTrue();

    List<EjercicioEntity> findByNombreContainingIgnoreCase(String nombre);
}