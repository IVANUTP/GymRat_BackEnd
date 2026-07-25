package com.gymRat.gymRatBackEnd.domain.usuarios.DTM;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UsuarioRequest {

    private Long idRol;

    private String nombre;

    private String correo;

    private String password;

    private String fotoPerfil;

    private BigDecimal pesoActual;

    private BigDecimal pesoObjetivo;

    private BigDecimal altura;

    private LocalDate fechaNacimiento;
}