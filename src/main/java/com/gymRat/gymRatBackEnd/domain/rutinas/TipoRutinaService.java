package com.gymRat.gymRatBackEnd.domain.rutinas;


import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.TipoRutinaRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.TipoRutinaResponseDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.TipoRutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.TipoRutinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TipoRutinaService {


    private final TipoRutinaRepository repository;



    public TipoRutinaResponseDTO guardar(
            TipoRutinaRequestDTO dto
    ){

        TipoRutinaEntity tipo = TipoRutinaEntity.builder()
                .nombre(dto.nombre())
                .descripcion(dto.descripcion())
                .build();


        tipo = repository.save(tipo);


        return mapear(tipo);
    }



    public List<TipoRutinaResponseDTO> listar(){

        return repository.findAll()
                .stream()
                .map(this::mapear)
                .toList();

    }



    public TipoRutinaResponseDTO buscarPorId(Long id){

        TipoRutinaEntity tipo =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException("Tipo rutina no encontrado")
                        );


        return mapear(tipo);
    }




    public void eliminar(Long id){

        repository.deleteById(id);

    }




    private TipoRutinaResponseDTO mapear(
            TipoRutinaEntity entity
    ){

        return new TipoRutinaResponseDTO(
                entity.getIdTipoRutina(),
                entity.getNombre(),
                entity.getDescripcion()
        );

    }

}