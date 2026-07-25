package com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs;

public record EjercicioRequestDTO(
        String nombre,
        String grupoMuscular,
        String descripcion,
        String imagen,
        String gif,
        String equipo,
        String dificultad

) {}