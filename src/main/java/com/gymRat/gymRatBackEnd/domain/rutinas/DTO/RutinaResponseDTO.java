package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;

import java.time.LocalDateTime;

public record RutinaResponseDTO(
        Long idRutina,
        Long idUsuario,
        String nombre,
        String descripcion,
        LocalDateTime fechaCreacion

) {}