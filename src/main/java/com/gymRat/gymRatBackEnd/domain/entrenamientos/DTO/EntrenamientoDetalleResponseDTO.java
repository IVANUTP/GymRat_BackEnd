package com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO;

import java.math.BigDecimal;

public record EntrenamientoDetalleResponseDTO(
        Long id,
        Long idEntrenamiento,
        Long idEjercicio,
        Integer serie,
        BigDecimal peso,
        Integer repeticiones,
        Integer rir

) {}