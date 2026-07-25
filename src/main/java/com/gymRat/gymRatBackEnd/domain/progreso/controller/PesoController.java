package com.gymRat.gymRatBackEnd.domain.progreso.controller;

import com.gymRat.gymRatBackEnd.domain.progreso.DTO.PesoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.DTO.PesoResponseDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.services.PesoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/peso")
@CrossOrigin(origins = "*")
public class PesoController {

    private final PesoService pesoService;

    public PesoController(
            PesoService pesoService
    ){
        this.pesoService = pesoService;
    }

    @PostMapping
    public ResponseEntity<PesoResponseDTO> guardar(
            @RequestBody PesoRequestDTO dto
    ){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        pesoService.guardar(dto)
                );

    }

    @GetMapping
    public ResponseEntity<List<PesoResponseDTO>> listar(){
        return ResponseEntity.ok(
                pesoService.listar()
        );

    }
    @GetMapping("/{id}")
    public ResponseEntity<PesoResponseDTO> buscar(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                pesoService.buscar(id)
        );
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PesoResponseDTO>> buscarPorUsuario(
            @PathVariable Long idUsuario
    ){
        return ResponseEntity.ok(
                pesoService.buscarPorUsuario(idUsuario)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PesoResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PesoRequestDTO dto
    ){
        return ResponseEntity.ok(
                pesoService.actualizar(id, dto)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){
        pesoService.eliminar(id);
        return ResponseEntity.noContent().build();

    }

}