package com.gymRat.gymRatBackEnd.domain.entrenamientos.repository;


import com.gymRat.gymRatBackEnd.domain.entrenamientos.entity.EntrenamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenamientoRepository
        extends JpaRepository<EntrenamientoEntity, Long> {


    List<EntrenamientoEntity> findByUsuario_IdUsuario(Long idUsuario);


    List<EntrenamientoEntity> findByRutina_IdRutina(Long idRutina);

}