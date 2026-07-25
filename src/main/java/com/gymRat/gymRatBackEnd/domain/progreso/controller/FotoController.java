package com.gymRat.gymRatBackEnd.domain.progreso.controller;

import com.gymRat.gymRatBackEnd.domain.progreso.DTO.FotoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.DTO.FotoResponseDTO;
import com.gymRat.gymRatBackEnd.domain.progreso.services.FotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/fotos")
@CrossOrigin(origins = "*")
public class FotoController {

    private final FotoService fotoService;

    public FotoController(
            FotoService fotoService
    ){

        this.fotoService = fotoService;

    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> guardar(
            @RequestBody FotoRequestDTO dto
    ){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        fotoService.guardar(dto)
                );

    }

    @GetMapping
    public ResponseEntity<List<FotoResponseDTO>> listar(){
        return ResponseEntity.ok(
                fotoService.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> buscar(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                fotoService.buscar(id)
        );

    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<FotoResponseDTO>> buscarPorUsuario(
            @PathVariable Long idUsuario
    ){
        return ResponseEntity.ok(
                fotoService.buscarPorUsuario(idUsuario)
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody FotoRequestDTO dto
    ){
        return ResponseEntity.ok(
                fotoService.actualizar(id, dto)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){
        fotoService.eliminar(id);
        return ResponseEntity.noContent().build();

    }

}