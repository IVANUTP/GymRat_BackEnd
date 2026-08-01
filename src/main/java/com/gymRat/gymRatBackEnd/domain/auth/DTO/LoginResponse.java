package com.gymRat.gymRatBackEnd.domain.auth.DTO;

import lombok.Builder;

@Builder
public  record LoginResponse(
        String token,
        Long idUsuario,
        String nombre,
        String correo,
        String rol
){}
