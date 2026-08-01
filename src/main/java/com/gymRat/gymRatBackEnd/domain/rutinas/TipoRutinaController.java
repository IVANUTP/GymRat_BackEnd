package com.gymRat.gymRatBackEnd.domain.rutinas;


import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.TipoRutinaRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.TipoRutinaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tipos-rutina")
@RequiredArgsConstructor
public class TipoRutinaController {


    private final TipoRutinaService service;

    @PostMapping
    public ResponseEntity<TipoRutinaResponseDTO> guardar(
            @RequestBody TipoRutinaRequestDTO dto
    ){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));

    }

    @GetMapping
    public ResponseEntity<List<TipoRutinaResponseDTO>> listar(){

        return ResponseEntity.ok(
                service.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoRutinaResponseDTO> buscar(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){

        service.eliminar(id);

        return ResponseEntity.noContent().build();

    }

}