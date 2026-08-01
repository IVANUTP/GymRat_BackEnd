package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;

import java.time.LocalDateTime;

public record RutinaResponseDTO(
        Long idRutina,
        Long idUsuario,
        String nombreUsuario,
        Long idObjetivo,
        String nombreObjetivo,
        Long idTipoRutina,
        String nombreTipoRutina,
        String nombre,
        String descripcion,
        Boolean esPlantilla,
        LocalDateTime fechaCreacion
) {}