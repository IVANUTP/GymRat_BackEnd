package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;

public record RutinaDetalleResponseDTO(
        Long id,
        Long idRutina,
        Long idEjercicio,
        String nombreEjercicio,
        Integer series,
        Integer repeticiones,
        Integer descanso,
        Integer orden

) {}