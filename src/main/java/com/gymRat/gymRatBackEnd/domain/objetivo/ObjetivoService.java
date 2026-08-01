package com.gymRat.gymRatBackEnd.domain.objetivo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjetivoService {

    private final ObjetivoRepository repository;

    public List<ObjetivoEntity> listar() {
        return repository.findAll();
    }

    public ObjetivoEntity obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
    }

    public ObjetivoEntity guardar(CrearObjetivoRecord record) {

        ObjetivoEntity objetivo = ObjetivoEntity.builder()
                .nombre(record.nombre())
                .build();

        return repository.save(objetivo);
    }

    public ObjetivoEntity actualizar(ActualizarObjetivoRecord record) {

        ObjetivoEntity objetivo = obtener(record.idObjetivo());

        objetivo.setNombre(record.nombre());

        return repository.save(objetivo);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}