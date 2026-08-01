package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;

public record RutinaRequestDTO(
        Long idUsuario,
        Long idObjetivo,
        Long idTipoRutina,
        String nombre,
        String descripcion,
        Boolean esPlantilla
) {}