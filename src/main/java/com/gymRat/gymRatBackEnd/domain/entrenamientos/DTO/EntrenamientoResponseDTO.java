package com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EntrenamientoResponseDTO(
        Long idEntrenamiento,
        Long idUsuario,
        Long idRutina,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        Integer duracion,
        BigDecimal volumenTotal

) {}