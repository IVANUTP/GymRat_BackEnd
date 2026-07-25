package com.gymRat.gymRatBackEnd.domain.progreso.DTO;

import java.time.LocalDateTime;

public record FotoResponseDTO(
        Long id,
        Long idUsuario,
        String url,
        LocalDateTime fecha

) {}