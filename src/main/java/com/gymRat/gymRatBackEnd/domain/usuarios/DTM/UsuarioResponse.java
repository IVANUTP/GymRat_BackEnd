package com.gymRat.gymRatBackEnd.domain.usuarios.DTM;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class UsuarioResponse {

    private Long idUsuario;

    private String nombre;

    private String correo;

    private String fotoPerfil;

    private BigDecimal pesoActual;

    private BigDecimal pesoObjetivo;

    private BigDecimal altura;

    private LocalDate fechaNacimiento;

    private String rol;

    private String nivel; // nombre del nivel: "Principiante", "Intermedio", "Avanzado"
}