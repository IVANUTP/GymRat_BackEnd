package com.gymRat.gymRatBackEnd.domain.progreso.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PesoResponseDTO(
        Long id,
        Long idUsuario,
        BigDecimal peso,
        LocalDateTime fecha

) {}