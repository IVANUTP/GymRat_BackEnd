package com.gymRat.gymRatBackEnd.domain.progreso.services;

import com.gymRat.gymRatBackEnd.domain.progreso.DTO.FotoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.DTO.FotoResponseDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.entity.FotoEntity;
import com.gymRat.gymRatBackEnd.domain.progreso.repository.FotoRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FotoService {

    private final FotoRepository fotoRepository;
    private final UsuarioRepository usuarioRepository;

    public FotoService(
            FotoRepository fotoRepository,
            UsuarioRepository usuarioRepository
    ){
        this.fotoRepository = fotoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public FotoResponseDTO guardar(
            FotoRequestDTO dto
    ){
        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );

        FotoEntity foto = new FotoEntity();

        foto.setUsuario(usuario);
        foto.setUrl(dto.url());
        return convertirDTO(
                fotoRepository.save(foto)
        );

    }

    public List<FotoResponseDTO> listar(){
        return fotoRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    public FotoResponseDTO buscar(Long id){
        FotoEntity foto =
                fotoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Foto no encontrada")
                        );
        return convertirDTO(foto);
    }

    public List<FotoResponseDTO> buscarPorUsuario(
            Long idUsuario
    ){
        return fotoRepository
                .findByUsuario_IdUsuarioOrderByFechaDesc(idUsuario)
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    public FotoResponseDTO actualizar(
            Long id,
            FotoRequestDTO dto
    ){
        FotoEntity foto =
                fotoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Foto no encontrada")
                        );
        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );
        foto.setUsuario(usuario);
        foto.setUrl(dto.url());
        return convertirDTO(
                fotoRepository.save(foto)
        );

    }

    public void eliminar(Long id){
        fotoRepository.deleteById(id);
    }

    private FotoResponseDTO convertirDTO(
            FotoEntity foto
    ){
        return new FotoResponseDTO(
                foto.getId(),
                foto.getUsuario()
                        .getIdUsuario(),
                foto.getUrl(),
                foto.getFecha()

        );

    }

}