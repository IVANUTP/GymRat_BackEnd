package com.gymRat.gymRatBackEnd.domain.recomendacion;

import com.gymRat.gymRatBackEnd.domain.recomendacion.DTO.RecomendacionRutinaRecord;
import com.gymRat.gymRatBackEnd.domain.recomendacion.service.RecomendacionRutinaService;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/recomendaciones-rutina")
@RequiredArgsConstructor
public class RecomendacionRutinaController {


    private final RecomendacionRutinaService service;



    @GetMapping
    public ResponseEntity<List<RecomendacionRutinaRecord>> findAll(){

        return ResponseEntity.ok(
                service.findAll()
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity<RecomendacionRutinaRecord> findById(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                service.findById(id)
        );
    }



    @PostMapping
    public ResponseEntity<RecomendacionRutinaRecord> save(
            @RequestBody RecomendacionRutinaRecord record
    ){

        return ResponseEntity.ok(
                service.save(record)
        );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recomendadas")
    public ResponseEntity<List<RutinaResponseDTO>> recomendadas(
            @RequestParam Long idObjetivo,
            @RequestParam Short idNivel,
            @RequestParam Short dias
    ) {
        return ResponseEntity.ok(service.buscarRecomendadas(idObjetivo, idNivel, dias));
    }
}