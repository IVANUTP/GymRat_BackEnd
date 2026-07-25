package com.gymRat.gymRatBackEnd.domain.usuarios;

import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

   private  final UsuarioService usuarioService;

   @GetMapping
    public List<UsuarioEntity> listar(){
       return  usuarioService.listar();
   }

   @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity>buscar(@PathVariable Long id){
       return ResponseEntity.ok(
               usuarioService.buscar(id)
       );
   }

   @PostMapping
    public ResponseEntity<UsuarioEntity>guardar(
            @RequestBody UsuarioEntity usuario
   ){
       return  ResponseEntity
               .status(HttpStatus.CREATED)
               .body(usuarioService.guardar(usuario));
   }
    @PutMapping("/{id}")
    public UsuarioEntity actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioEntity usuario
    ){
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ) {

        usuarioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}
