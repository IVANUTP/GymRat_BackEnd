package com.gymRat.gymRatBackEnd.domain.ejercicios;


import com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs.EjercicioRequestDTO;
import com.gymRat.gymRatBackEnd.domain.ejercicios.DTOs.EjercicioResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ejercicios")
@CrossOrigin(origins = "*")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService){
        this.ejercicioService = ejercicioService;
    }

    @PostMapping
    public ResponseEntity<EjercicioResponseDTO> guardar(
            @RequestBody EjercicioRequestDTO dto
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ejercicioService.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EjercicioResponseDTO>> listar(){

        return ResponseEntity.ok(
                ejercicioService.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioResponseDTO> buscar(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                ejercicioService.buscar(id)
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<EjercicioResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EjercicioRequestDTO dto
    ){

        return ResponseEntity.ok(
                ejercicioService.actualizar(id, dto)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){

        ejercicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}