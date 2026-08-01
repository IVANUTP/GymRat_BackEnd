package com.gymRat.gymRatBackEnd.domain.objetivo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObjetivoRepository extends JpaRepository<ObjetivoEntity, Long> {

    Optional<ObjetivoEntity> findByNombre(String nombre);

}