package com.gymRat.gymRatBackEnd.domain.rutinas.DTO;


public record RutinaRequestDTO(
        Long idUsuario,
        String nombre,
        String descripcion

) {}