package com.gymRat.gymRatBackEnd.domain.progreso.DTO;

import java.math.BigDecimal;

public record PesoRequestDTO(
        Long idUsuario,
        BigDecimal peso

) {}