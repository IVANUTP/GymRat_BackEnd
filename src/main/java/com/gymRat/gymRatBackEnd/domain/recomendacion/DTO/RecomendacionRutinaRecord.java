package com.gymRat.gymRatBackEnd.domain.recomendacion.DTO;

public record RecomendacionRutinaRecord(

        Long idRecomendacion,
        Long idObjetivo,
        Long idTipoRutina,
        Short idNivel,
        Short diasMin,
        Short diasMax,
        Short prioridad

) {
}