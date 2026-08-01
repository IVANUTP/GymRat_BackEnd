package com.gymRat.gymRatBackEnd.domain.usuarios;

import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.Nivel;
import com.gymRat.gymRatBackEnd.domain.recomendacion.repository.NivelRepository;
import com.gymRat.gymRatBackEnd.domain.rol.entity.RolEntity;
import com.gymRat.gymRatBackEnd.domain.rol.repository.RolRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.DTM.CrearUsuarioRequest;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolRepository rolRepository;
    private final NivelRepository nivelRepository;

    public List<UsuarioEntity> listar() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    public UsuarioEntity guardar(CrearUsuarioRequest request) {

        RolEntity rol = rolRepository.findById(request.rol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Nivel por defecto = 1 (Principiante) si no viene en el request
        Short idNivel = request.idNivel() != null ? request.idNivel() : (short) 1;
        Nivel nivel = nivelRepository.findById(idNivel)
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado"));

        UsuarioEntity usuario = UsuarioEntity.builder()
                .rol(rol)
                .nivel(nivel)
                .nombre(request.nombre())
                .correo(request.correo())
                .password(passwordEncoder.encode(request.password()))
                .fotoPerfil(request.fotoPerfil())
                .pesoActual(request.pesoActual())
                .pesoObjetivo(request.pesoObjetivo())
                .altura(request.altura())
                .fechaNacimiento(request.fechaNacimiento())
                .build();

        return usuarioRepository.save(usuario);
    }
    public UsuarioEntity actualizar(Long id, UsuarioEntity datos) {

        UsuarioEntity usuario = buscar(id);

        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());

        if (datos.getPassword() != null) {
            usuario.setPassword(passwordEncoder.encode(datos.getPassword()));
        }

        usuario.setPesoActual(datos.getPesoActual());
        usuario.setPesoObjetivo(datos.getPesoObjetivo());
        usuario.setAltura(datos.getAltura());
        usuario.setFechaNacimiento(datos.getFechaNacimiento());
        usuario.setFotoPerfil(datos.getFotoPerfil());

        if (datos.getNivel() != null) {
            usuario.setNivel(datos.getNivel());
        }

        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {
        UsuarioEntity usuario = buscar(id);
        usuarioRepository.delete(usuario);
    }
}