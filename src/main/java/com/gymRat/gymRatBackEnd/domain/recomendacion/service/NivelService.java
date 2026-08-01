package com.gymRat.gymRatBackEnd.domain.recomendacion.service;


import com.gymRat.gymRatBackEnd.domain.recomendacion.DTO.NivelRecord;
import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.Nivel;
import com.gymRat.gymRatBackEnd.domain.recomendacion.repository.NivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NivelService {


    private final NivelRepository repository;


    public List<NivelRecord> findAll(){

        return repository.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }


    public NivelRecord findById(Short id){

        Nivel nivel = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Nivel no encontrado")
                );

        return toRecord(nivel);
    }


    public NivelRecord save(NivelRecord record){

        Nivel nivel = Nivel.builder()
                .idNivel(record.idNivel())
                .nombre(record.nombre())
                .build();


        return toRecord(repository.save(nivel));
    }


    public void delete(Short id){

        repository.deleteById(id);
    }


    private NivelRecord toRecord(Nivel nivel){

        return new NivelRecord(
                nivel.getIdNivel(),
                nivel.getNombre()
        );
    }
}