package com.gymRat.gymRatBackEnd.domain.usuarios.repository;


import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByCorreo(String correo);

    boolean existsByCorreo(String correo);
}