package com.gymRat.gymRatBackEnd.domain.objetivo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetivos")
@RequiredArgsConstructor
public class ObjetivoController {

    private final ObjetivoService service;

    @GetMapping
    public List<ObjetivoEntity> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ObjetivoEntity obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<ObjetivoEntity> guardar(
            @Valid @RequestBody CrearObjetivoRecord record
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(record));
    }

    @PutMapping
    public ObjetivoEntity actualizar(
            @Valid @RequestBody ActualizarObjetivoRecord record
    ) {
        return service.actualizar(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}