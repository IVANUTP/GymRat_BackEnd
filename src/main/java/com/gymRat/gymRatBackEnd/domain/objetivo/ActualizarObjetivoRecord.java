package com.gymRat.gymRatBackEnd.domain.objetivo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record ActualizarObjetivoRecord(

        @NotNull
        Long idObjetivo,

        @NotBlank
        String nombre

) {
}