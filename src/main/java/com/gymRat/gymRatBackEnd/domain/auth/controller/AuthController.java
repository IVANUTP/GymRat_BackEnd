package com.gymRat.gymRatBackEnd.domain.auth.controller;

import com.gymRat.gymRatBackEnd.domain.auth.DTO.LoginRequest;
import com.gymRat.gymRatBackEnd.domain.auth.DTO.LoginResponse;
import com.gymRat.gymRatBackEnd.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private  final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
