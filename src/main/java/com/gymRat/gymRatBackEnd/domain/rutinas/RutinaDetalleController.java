package com.gymRat.gymRatBackEnd.domain.rutinas;

import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaDetalleRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaDetalleResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/rutina-detalle")
@CrossOrigin(origins = "*")
public class RutinaDetalleController {

    private final RutinaDetalleService detalleService;

    public RutinaDetalleController(
            RutinaDetalleService detalleService
    ) {
        this.detalleService = detalleService;
    }

    @PostMapping
    public ResponseEntity<RutinaDetalleResponseDTO> guardar(
            @RequestBody RutinaDetalleRequestDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(detalleService.guardar(dto));

    }

    @GetMapping
    public ResponseEntity<List<RutinaDetalleResponseDTO>> listar() {

        return ResponseEntity.ok(
                detalleService.listar()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaDetalleResponseDTO> buscar(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                detalleService.buscar(id)
        );

    }

    @GetMapping("/rutina/{idRutina}")
    public ResponseEntity<List<RutinaDetalleResponseDTO>> buscarPorRutina(
            @PathVariable Long idRutina
    ){
        return ResponseEntity.ok(
                detalleService.buscarPorRutina(idRutina)
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaDetalleResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RutinaDetalleRequestDTO dto
    ){
        return ResponseEntity.ok(
                detalleService.actualizar(id,dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ){

        detalleService.eliminar(id);

        return ResponseEntity.noContent().build();

    }


}