package com.gymRat.gymRatBackEnd.domain.recomendacion.service;

import com.gymRat.gymRatBackEnd.domain.objetivo.ObjetivoRepository;
import com.gymRat.gymRatBackEnd.domain.recomendacion.DTO.RecomendacionRutinaRecord;
import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.RecomendacionRutina;
import com.gymRat.gymRatBackEnd.domain.recomendacion.repository.NivelRepository;
import com.gymRat.gymRatBackEnd.domain.recomendacion.repository.RecomendacionRutinaRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaResponseDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.TipoRutinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomendacionRutinaService {


    private final RecomendacionRutinaRepository  recomendacionRutinaRepository;
    private final ObjetivoRepository objetivoRepository;
    private final TipoRutinaRepository tipoRutinaRepository;
    private final NivelRepository nivelRepository;
    private  final RutinaRepository rutinaRepository;



    public List<RecomendacionRutinaRecord> findAll(){

        return recomendacionRutinaRepository.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }



    public RecomendacionRutinaRecord findById(Long id){

        RecomendacionRutina recomendacion = recomendacionRutinaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recomendación no encontrada")
                );


        return toRecord(recomendacion);
    }



    public RecomendacionRutinaRecord save(
            RecomendacionRutinaRecord record
    ){

        RecomendacionRutina recomendacion = RecomendacionRutina.builder()

                .objetivo(
                        objetivoRepository.findById(record.idObjetivo())
                                .orElseThrow()
                )

                .tipoRutina(
                        tipoRutinaRepository.findById(record.idTipoRutina())
                                .orElseThrow()
                )

                .nivel(
                        nivelRepository.findById(record.idNivel())
                                .orElseThrow()
                )

                .diasMin(record.diasMin())
                .diasMax(record.diasMax())
                .prioridad(record.prioridad())

                .build();



        return toRecord(recomendacionRutinaRepository.save(recomendacion));
    }




    public void delete(Long id){

        recomendacionRutinaRepository.deleteById(id);
    }
    public List<RutinaResponseDTO> buscarRecomendadas(Long idObjetivo, Short idNivel, Short dias) {

        RecomendacionRutina recomendacion = recomendacionRutinaRepository
                .findFirstByObjetivo_IdObjetivoAndNivel_IdNivelAndDiasMinLessThanEqualAndDiasMaxGreaterThanEqualOrderByPrioridadDesc(
                        idObjetivo, idNivel, dias, dias)
                .orElseThrow(() -> new RuntimeException("No hay recomendación disponible para esos parámetros"));

        Long idTipoRutina = recomendacion.getTipoRutina().getIdTipoRutina();

        List<RutinaEntity> plantillas = rutinaRepository
                .findByObjetivo_IdObjetivoAndTipoRutina_IdTipoRutinaAndEsPlantillaTrue(idObjetivo, idTipoRutina);

        return plantillas.stream().map(this::convertir).toList();
    }
    private RutinaResponseDTO convertir(RutinaEntity rutina) {
        Long idUsuario = rutina.getUsuario() != null ? rutina.getUsuario().getIdUsuario() : null;
        String nombreUsuario = rutina.getUsuario() != null ? rutina.getUsuario().getNombre() : null;

        return new RutinaResponseDTO(
                rutina.getIdRutina(),
                idUsuario,
                nombreUsuario,
                rutina.getObjetivo().getIdObjetivo(),
                rutina.getObjetivo().getNombre(),
                rutina.getTipoRutina().getIdTipoRutina(),
                rutina.getTipoRutina().getNombre(),
                rutina.getNombre(),
                rutina.getDescripcion(),
                rutina.getEsPlantilla(),
                rutina.getFechaCreacion()
        );
    }


    private RecomendacionRutinaRecord toRecord(
            RecomendacionRutina entity
    ){

        return new RecomendacionRutinaRecord(

                entity.getIdRecomendacion(),
                entity.getObjetivo().getIdObjetivo(),
                entity.getTipoRutina().getIdTipoRutina(),
                entity.getNivel().getIdNivel(),
                entity.getDiasMin(),
                entity.getDiasMax(),
                entity.getPrioridad()
        );
    }
}