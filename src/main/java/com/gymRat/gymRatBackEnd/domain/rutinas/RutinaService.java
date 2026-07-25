package com.gymRat.gymRatBackEnd.domain.rutinas;


import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaResponseDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    private  final RutinaRepository rutinaRepository;
    private final UsuarioRepository usuarioRepository;

    public  RutinaService(RutinaRepository rutinaRepository, UsuarioRepository usuarioRepository){
        this.rutinaRepository=rutinaRepository;
        this.usuarioRepository=usuarioRepository;
    }

    //guardar la rutina
    public RutinaResponseDTO guardar(RutinaRequestDTO dto){
        UsuarioEntity usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );
        RutinaEntity rutina = new RutinaEntity();
        rutina.setUsuario(usuario);
        rutina.setNombre(dto.nombre());
        rutina.setDescripcion(dto.descripcion());
        RutinaEntity guardada =
                rutinaRepository.save(rutina);
        return convertidorDTO(guardada);

    }
    // LISTAR

    public List<RutinaResponseDTO> listar(){
        return rutinaRepository.findAll()
                .stream()
                .map(this::convertidorDTO)
                .toList();

    }

    // BUSCAR
    public RutinaResponseDTO buscar(Long id){
        RutinaEntity rutina =
                rutinaRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Rutina no encontrada")
                        );
        return convertidorDTO(rutina);

    }

    // ACTUALIZAR

    public RutinaResponseDTO actualizar(
            Long id,
            RutinaRequestDTO dto
    ){
        RutinaEntity rutina =
                rutinaRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Rutina no encontrada")
                        );
        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );
        rutina.setUsuario(usuario);
        rutina.setNombre(dto.nombre());
        rutina.setDescripcion(dto.descripcion());
        RutinaEntity actualizada =
                rutinaRepository.save(rutina);
        return convertidorDTO(actualizada);
    }

    // ELIMINAR

    public void eliminar(Long id){

        if(!rutinaRepository.existsById(id)){
            throw new RuntimeException("Rutina no encontrada");
        }

        rutinaRepository.deleteById(id);

    }
    private RutinaResponseDTO convertidorDTO(RutinaEntity rutina){
        return  new RutinaResponseDTO(
                rutina.getIdRutina(),
                rutina.getUsuario().getIdUsuario(),
                rutina.getNombre(),
                rutina.getDescripcion(),
                rutina.getFechaCreacion()
        );
    }

}
