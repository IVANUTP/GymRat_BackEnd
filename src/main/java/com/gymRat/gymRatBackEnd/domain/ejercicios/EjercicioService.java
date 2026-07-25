package com.gymRat.gymRatBackEnd.domain.ejercicios;

import com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs.EjercicioRequestDTO;
import com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs.EjercicioResponseDTO;
import com.gymRat.gymRatBackEnd.domain.ejercicios.Entity.EjercicioEntity;
import com.gymRat.gymRatBackEnd.domain.ejercicios.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {


    private final EjercicioRepository ejercicioRepository;
    public EjercicioService(EjercicioRepository ejercicioRepository){
        this.ejercicioRepository = ejercicioRepository;
    }

    // CREAR
    public EjercicioResponseDTO guardar(EjercicioRequestDTO dto){

        EjercicioEntity ejercicio = new EjercicioEntity();

        ejercicio.setNombre(dto.nombre());
        ejercicio.setGrupoMuscular(dto.grupoMuscular());
        ejercicio.setDescripcion(dto.descripcion());
        ejercicio.setImagen(dto.imagen());
        ejercicio.setGif(dto.gif());
        ejercicio.setEquipo(dto.equipo());
        ejercicio.setDificultad(dto.dificultad());
        ejercicio.setActivo(true);
        EjercicioEntity guardado = ejercicioRepository.save(ejercicio);

        return convertirDTO(guardado);
    }



    // LISTAR
    public List<EjercicioResponseDTO> listar(){

        return ejercicioRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    // BUSCAR
    public EjercicioResponseDTO buscar(Long id){

        EjercicioEntity ejercicio = ejercicioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ejercicio no encontrado")
                );

        return convertirDTO(ejercicio);
    }

    // ACTUALIZAR
    public EjercicioResponseDTO actualizar(
            Long id,
            EjercicioRequestDTO dto
    ){

        EjercicioEntity ejercicio = ejercicioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ejercicio no encontrado")
                );

            ejercicio.setNombre(dto.nombre());
            ejercicio.setGrupoMuscular(dto.grupoMuscular());
            ejercicio.setDescripcion(dto.descripcion());
            ejercicio.setImagen(dto.imagen());
            ejercicio.setGif(dto.gif());
            ejercicio.setEquipo(dto.equipo());
            ejercicio.setDificultad(dto.dificultad());
        EjercicioEntity actualizado =
                ejercicioRepository.save(ejercicio);
        return convertirDTO(actualizado);
    }
    // ELIMINAR
    public void eliminar(Long id){

        if(!ejercicioRepository.existsById(id)){
            throw new RuntimeException("Ejercicio no encontrado");
        }

        ejercicioRepository.deleteById(id);

    }
    // ENTITY -> DTO
    private EjercicioResponseDTO convertirDTO(
            EjercicioEntity ejercicio
    ){

        return EjercicioResponseDTO.builder()
                .idEjercicio(ejercicio.getIdEjercicio())
                .nombre(ejercicio.getNombre())
                .grupoMuscular(ejercicio.getGrupoMuscular())
                .descripcion(ejercicio.getDescripcion())
                .imagen(ejercicio.getImagen())
                .gif(ejercicio.getGif())
                .equipo(ejercicio.getEquipo())
                .dificultad(ejercicio.getDificultad())
                .fechaCreacion(ejercicio.getFechaCreacion())
                .activo(ejercicio.getActivo())
                .build();

    }

}