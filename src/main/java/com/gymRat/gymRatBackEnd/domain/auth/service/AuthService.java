package com.gymRat.gymRatBackEnd.domain.auth.service;

import com.gymRat.gymRatBackEnd.domain.auth.DTO.LoginRequest;
import com.gymRat.gymRatBackEnd.domain.auth.DTO.LoginResponse;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import com.gymRat.gymRatBackEnd.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private  final UsuarioRepository usuarioRepository;
    private  final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;

    public LoginResponse login(LoginRequest request){

        UsuarioEntity usuario=usuarioRepository.findByCorreo(request.getCorreo())
                .orElseThrow(()-> new RuntimeException("Correo no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())){
            throw new RuntimeException("Contraseña Incorrecta");
        }
        String token=jwtService.generateToken(usuario.getCorreo());

        return LoginResponse.builder()
                .token(token)
                .idUsuario(usuario.getIdUsuario())
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .rol(usuario.getRol().getNombre())
                .build();

    }
}
