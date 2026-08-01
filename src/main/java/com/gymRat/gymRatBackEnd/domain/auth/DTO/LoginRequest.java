package com.gymRat.gymRatBackEnd.domain.auth.DTO;

import lombok.Data;

@Data
public class LoginRequest {

    private  String correo;
    private String password;

}
