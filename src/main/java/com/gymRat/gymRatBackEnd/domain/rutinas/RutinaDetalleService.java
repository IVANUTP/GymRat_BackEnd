package com.gymRat.gymRatBackEnd.domain.rutinas;

import com.gymRat.gymRatBackEnd.domain.ejercicios.Entity.EjercicioEntity;
import com.gymRat.gymRatBackEnd.domain.ejercicios.repository.EjercicioRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaDetalleRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaDetalleResponseDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaDetalleEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaDetalleRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RutinaDetalleService {


    private final RutinaDetalleRepository detalleRepository;
    private final RutinaRepository rutinaRepository;
    private final EjercicioRepository ejercicioRepository;

    public RutinaDetalleService(
            RutinaDetalleRepository detalleRepository,
            RutinaRepository rutinaRepository,
            EjercicioRepository ejercicioRepository
    ){
        this.detalleRepository = detalleRepository;
        this.rutinaRepository = rutinaRepository;
        this.ejercicioRepository = ejercicioRepository;

    }

    // CREAR
    public RutinaDetalleResponseDTO guardar(
            RutinaDetalleRequestDTO dto
    ){
        RutinaEntity rutina =
                rutinaRepository.findById(dto.idRutina())
                        .orElseThrow(() ->
                                new RuntimeException("Rutina no encontrada")
                        );
        EjercicioEntity ejercicio =
                ejercicioRepository.findById(dto.idEjercicio())
                        .orElseThrow(() ->
                                new RuntimeException("Ejercicio no encontrado")
                        );
        RutinaDetalleEntity detalle =
                new RutinaDetalleEntity();
        detalle.setRutina(rutina);
        detalle.setEjercicio(ejercicio);
        detalle.setSeries(dto.series());
        detalle.setRepeticiones(dto.repeticiones());
        detalle.setDescanso(dto.descanso());
        detalle.setOrden(dto.orden());
        return convertirDTO(
                detalleRepository.save(detalle)
        );

    }
    // LISTAR

    public List<RutinaDetalleResponseDTO> listar(){
        return detalleRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }
    // BUSCAR POR ID

    public RutinaDetalleResponseDTO buscar(Long id){
        RutinaDetalleEntity detalle =
                detalleRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Detalle no encontrado")
                        );
        return convertirDTO(detalle);

    }

    // BUSCAR POR RUTINA

    public List<RutinaDetalleResponseDTO> buscarPorRutina(
            Long idRutina
    ){
        return detalleRepository
                .findByRutina_IdRutina(idRutina)
                .stream()
                .map(this::convertirDTO)
                .toList();

    }




    // ACTUALIZAR

    public RutinaDetalleResponseDTO actualizar(
            Long id,
            RutinaDetalleRequestDTO dto
    ){


        RutinaDetalleEntity detalle =
                detalleRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Detalle no encontrado")
                        );


        RutinaEntity rutina =
                rutinaRepository.findById(dto.idRutina())
                        .orElseThrow();


        EjercicioEntity ejercicio =
                ejercicioRepository.findById(dto.idEjercicio())
                        .orElseThrow();



        detalle.setRutina(rutina);
        detalle.setEjercicio(ejercicio);
        detalle.setSeries(dto.series());
        detalle.setRepeticiones(dto.repeticiones());
        detalle.setDescanso(dto.descanso());
        detalle.setOrden(dto.orden());



        return convertirDTO(
                detalleRepository.save(detalle)
        );

    }




    public void eliminar(Long id){

        if(!detalleRepository.existsById(id)){
            throw new RuntimeException("Detalle no encontrado");
        }


        detalleRepository.deleteById(id);

    }





    private RutinaDetalleResponseDTO convertirDTO(
            RutinaDetalleEntity detalle
    ){


        return new RutinaDetalleResponseDTO(

                detalle.getId(),

                detalle.getRutina().getIdRutina(),

                detalle.getEjercicio().getIdEjercicio(),

                detalle.getEjercicio().getNombre(),

                detalle.getSeries(),

                detalle.getRepeticiones(),

                detalle.getDescanso(),

                detalle.getOrden()

        );

    }


}