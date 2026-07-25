package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;

public record RutinaDetalleRequestDTO(
        Long idRutina,
        Long idEjercicio,
        Integer series,
        Integer repeticiones,
        Integer descanso,
        Integer orden

) {}