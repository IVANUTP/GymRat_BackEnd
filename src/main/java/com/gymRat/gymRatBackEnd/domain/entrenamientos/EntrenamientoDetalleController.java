package com.gymRat.gymRatBackEnd.domain.entrenamientos;

import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoDetalleRequestDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoDetalleResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenamiento-detalle")
@CrossOrigin(origins = "*")
public class EntrenamientoDetalleController {

    private final EntrenamientoDetalleService service;

    public EntrenamientoDetalleController(
            EntrenamientoDetalleService service
    ){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EntrenamientoDetalleResponseDTO> guardar(
            @RequestBody EntrenamientoDetalleRequestDTO dto
    ){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));

    }

    @GetMapping
    public ResponseEntity<List<EntrenamientoDetalleResponseDTO>> listar(){
        return ResponseEntity.ok(
                service.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenamientoDetalleResponseDTO> buscar(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                service.buscar(id)
        );
    }

    @GetMapping("/entrenamiento/{id}")
    public ResponseEntity<List<EntrenamientoDetalleResponseDTO>> buscarPorEntrenamiento(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                service.buscarPorEntrenamiento(id)
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