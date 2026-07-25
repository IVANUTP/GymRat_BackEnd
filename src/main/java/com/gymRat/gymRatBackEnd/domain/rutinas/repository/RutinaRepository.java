package com.gymRat.gymRatBackEnd.domain.rutinas.repository;

import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutinaRepository extends JpaRepository<RutinaEntity, Long > {
       List<RutinaEntity> findByUsuario_IdUsuario(Long idUsuario);
       List<RutinaEntity> findByNombreContainingIgnoreCase(String nombre);
}
