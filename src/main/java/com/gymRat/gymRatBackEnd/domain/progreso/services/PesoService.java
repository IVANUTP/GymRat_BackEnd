package com.gymRat.gymRatBackEnd.domain.progreso.services;

import com.gymRat.gymRatBackEnd.domain.progreso.DTO.PesoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.DTO.PesoResponseDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.entity.PesoEntity;
import com.gymRat.gymRatBackEnd.domain.progreso.repository.PesoRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesoService {


    private final PesoRepository pesoRepository;
    private final UsuarioRepository usuarioRepository;


    public PesoService(
            PesoRepository pesoRepository,
            UsuarioRepository usuarioRepository
    ){
        this.pesoRepository = pesoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public PesoResponseDTO guardar(
            PesoRequestDTO dto
    ){

        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );


        PesoEntity peso = new PesoEntity();

        peso.setUsuario(usuario);
        peso.setPeso(dto.peso());


        return convertirDTO(
                pesoRepository.save(peso)
        );

    }



    public List<PesoResponseDTO> listar(){

        return pesoRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }



    public PesoResponseDTO buscar(Long id){

        PesoEntity peso =
                pesoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Peso no encontrado")
                        );


        return convertirDTO(peso);

    }



    public List<PesoResponseDTO> buscarPorUsuario(
            Long idUsuario
    ){

        return pesoRepository
                .findByUsuario_IdUsuarioOrderByFechaDesc(idUsuario)
                .stream()
                .map(this::convertirDTO)
                .toList();

    }



    public PesoResponseDTO actualizar(
            Long id,
            PesoRequestDTO dto
    ){

        PesoEntity peso =
                pesoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Peso no encontrado")
                        );


        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );


        peso.setUsuario(usuario);
        peso.setPeso(dto.peso());


        return convertirDTO(
                pesoRepository.save(peso)
        );

    }

    public void eliminar(Long id){

        pesoRepository.deleteById(id);

    }



    private PesoResponseDTO convertirDTO(
            PesoEntity peso
    ){

        return new PesoResponseDTO(

                peso.getId(),

                peso.getUsuario()
                        .getIdUsuario(),

                peso.getPeso(),

                peso.getFecha()

        );

    }

}