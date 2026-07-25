package com.gymRat.gymRatBackEnd.domain.entrenamientos;

import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenamientos")
@CrossOrigin(origins = "*")
public class EntrenamientoController {

    private final EntrenamientoService entrenamientoService;

    public EntrenamientoController(
            EntrenamientoService entrenamientoService
    ){
        this.entrenamientoService = entrenamientoService;
    }

    @PostMapping
    public ResponseEntity<EntrenamientoResponseDTO> guardar(
            @RequestBody EntrenamientoRequestDTO dto
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        entrenamientoService.guardar(dto)
                );
    }

    @GetMapping
    public ResponseEntity<List<EntrenamientoResponseDTO>> listar(){

        return ResponseEntity.ok(
                entrenamientoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenamientoResponseDTO> buscar(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                entrenamientoService.buscar(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenamientoResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EntrenamientoRequestDTO dto
    ){

        return ResponseEntity.ok(
                entrenamientoService.actualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){
        entrenamientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}