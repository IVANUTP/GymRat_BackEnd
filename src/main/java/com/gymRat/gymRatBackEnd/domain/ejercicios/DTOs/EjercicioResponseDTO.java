package com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EjercicioResponseDTO(
        Long idEjercicio,
        String nombre,
        String grupoMuscular,
        String descripcion,
        String imagen,
        String gif,
        String equipo,
        String dificultad,
        LocalDateTime fechaCreacion,
        Boolean activo

) {}