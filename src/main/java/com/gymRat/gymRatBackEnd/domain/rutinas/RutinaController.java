package com.gymRat.gymRatBackEnd.domain.rutinas;

import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
@CrossOrigin(origins = "*")
public class RutinaController {

    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    @PostMapping
    public ResponseEntity<RutinaResponseDTO> guardar(@RequestBody RutinaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaService.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<RutinaResponseDTO>> listar() {
        return ResponseEntity.ok(rutinaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(rutinaService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RutinaRequestDTO dto
    ) {
        return ResponseEntity.ok(rutinaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rutinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}