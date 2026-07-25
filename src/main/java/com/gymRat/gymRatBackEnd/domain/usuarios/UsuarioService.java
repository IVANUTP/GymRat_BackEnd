package com.gymRat.gymRatBackEnd.domain.usuarios;

import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private  final PasswordEncoder passwordEncoder;


    public List<UsuarioEntity> listar() {
        return usuarioRepository.findAll();
    }


    public UsuarioEntity buscar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );
    }


    public UsuarioEntity guardar(UsuarioEntity usuario){

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        if(usuario.getFechaCreacion() == null){
            usuario.setFechaCreacion(LocalDateTime.now());
        }

        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity actualizar(Long id, UsuarioEntity datos){

        UsuarioEntity usuario = buscar(id);


        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());


        if(datos.getPassword() != null){
            usuario.setPassword(passwordEncoder.encode(datos.getPassword()));
        }


        usuario.setPesoActual(datos.getPesoActual());
        usuario.setPesoObjetivo(datos.getPesoObjetivo());
        usuario.setAltura(datos.getAltura());
        usuario.setFechaNacimiento(datos.getFechaNacimiento());
        usuario.setFotoPerfil(datos.getFotoPerfil());


        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {

        UsuarioEntity usuario = buscar(id);

        usuarioRepository.delete(usuario);
    }
}