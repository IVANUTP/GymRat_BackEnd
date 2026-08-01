package com.gymRat.gymRatBackEnd.domain.objetivo;

import jakarta.validation.constraints.NotBlank;

public record CrearObjetivoRecord(

        @NotBlank
        String nombre

) {
}