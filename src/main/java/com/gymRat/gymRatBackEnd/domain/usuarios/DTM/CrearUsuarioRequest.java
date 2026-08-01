package com.gymRat.gymRatBackEnd.domain.usuarios.DTM;

import java.math.BigDecimal;
import java.time.LocalDate;
public record CrearUsuarioRequest(
        Long rol,
        Short idNivel,
        String nombre,
        String correo,
        String password,
        String fotoPerfil,
        BigDecimal pesoActual,
        BigDecimal pesoObjetivo,
        BigDecimal altura,
        LocalDate fechaNacimiento
) {}