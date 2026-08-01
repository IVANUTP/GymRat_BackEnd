package com.gymRat.gymRatBackEnd.domain.recomendacion;

import com.gymRat.gymRatBackEnd.domain.recomendacion.DTO.NivelRecord;
import com.gymRat.gymRatBackEnd.domain.recomendacion.service.NivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/niveles")
@RequiredArgsConstructor
public class NivelController {

    private final NivelService service;

    @GetMapping
    public ResponseEntity<List<NivelRecord>> findAll(){

        return ResponseEntity.ok(
                service.findAll()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<NivelRecord> findById(
            @PathVariable Short id
    ){

        return ResponseEntity.ok(
                service.findById(id)
        );
    }
    @PostMapping
    public ResponseEntity<NivelRecord> save(
            @RequestBody NivelRecord record
    ){

        return ResponseEntity.ok(
                service.save(record)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Short id
    ){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}