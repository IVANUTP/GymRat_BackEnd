package com.gymRat.gymRatBackEnd.domain.entrenamientos;

import com.gymRat.gymRatBackEnd.domain.ejercicios.repository.EjercicioRepository;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoDetalleRequestDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoDetalleResponseDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.entity.EntrenamientoDetalleEntity;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.entity.EntrenamientoEntity;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.repository.EntrenamientoDetalleRepository;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.repository.EntrenamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntrenamientoDetalleService {


    private final EntrenamientoDetalleRepository repository;
    private final EntrenamientoRepository entrenamientoRepository;
    private final EjercicioRepository ejercicioRepository;
    public EntrenamientoDetalleService(
            EntrenamientoDetalleRepository repository,
            EntrenamientoRepository entrenamientoRepository,
            EjercicioRepository ejercicioRepository
    ){
        this.repository = repository;
        this.entrenamientoRepository = entrenamientoRepository;
        this.ejercicioRepository = ejercicioRepository;
    }
    public EntrenamientoDetalleResponseDTO guardar(
            EntrenamientoDetalleRequestDTO dto
    ){
        EntrenamientoEntity entrenamiento =
                entrenamientoRepository.findById(dto.idEntrenamiento())
                        .orElseThrow(() ->
                                new RuntimeException("Entrenamiento no encontrado")
                        );
        var ejercicio =
                ejercicioRepository.findById(dto.idEjercicio())
                        .orElseThrow(() ->
                                new RuntimeException("Ejercicio no encontrado")
                        );
        EntrenamientoDetalleEntity detalle =
                new EntrenamientoDetalleEntity();
        detalle.setEntrenamiento(entrenamiento);
        detalle.setEjercicio(ejercicio);
        detalle.setSerie(dto.serie());
        detalle.setPeso(dto.peso());
        detalle.setRepeticiones(dto.repeticiones());
        detalle.setRir(dto.rir());
        return convertirDTO(
                repository.save(detalle)
        );

    }

    public List<EntrenamientoDetalleResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    public EntrenamientoDetalleResponseDTO buscar(Long id){
        return convertirDTO(
                repository.findById(id)
                        .orElseThrow()
        );
    }

    public List<EntrenamientoDetalleResponseDTO> buscarPorEntrenamiento(
            Long id
    ){
        return repository
                .findByEntrenamiento_IdEntrenamiento(id)
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    public void eliminar(Long id){
        repository.deleteById(id);

    }

    private EntrenamientoDetalleResponseDTO convertirDTO(
            EntrenamientoDetalleEntity e
    ){
        return new EntrenamientoDetalleResponseDTO(
                e.getId(),
                e.getEntrenamiento()
                        .getIdEntrenamiento(),

                e.getEjercicio()
                        .getIdEjercicio(),

                e.getSerie(),

                e.getPeso(),

                e.getRepeticiones(),

                e.getRir()
        );

    }


}