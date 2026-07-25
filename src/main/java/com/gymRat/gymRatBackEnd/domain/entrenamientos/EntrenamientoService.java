package com.gymRat.gymRatBackEnd.domain.entrenamientos;

import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoRequestDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.DTO.EntrenamientoResponseDTO;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.entity.EntrenamientoEntity;
import com.gymRat.gymRatBackEnd.domain.entrenamientos.repository.EntrenamientoRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntrenamientoService {

    private final EntrenamientoRepository entrenamientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final RutinaRepository rutinaRepository;

    public EntrenamientoService(
            EntrenamientoRepository entrenamientoRepository,
            UsuarioRepository usuarioRepository,
            RutinaRepository rutinaRepository
    ){
        this.entrenamientoRepository = entrenamientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.rutinaRepository = rutinaRepository;
    }

    public EntrenamientoResponseDTO guardar(
            EntrenamientoRequestDTO dto
    ){
        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow(() ->
                                new RuntimeException("Usuario no encontrado")
                        );
        RutinaEntity rutina = null;
        if(dto.idRutina()!=null){
            rutina =
                    rutinaRepository.findById(dto.idRutina())
                            .orElseThrow(() ->
                                    new RuntimeException("Rutina no encontrada")
                            );

        }
        EntrenamientoEntity entrenamiento =
                new EntrenamientoEntity();
        entrenamiento.setUsuario(usuario);
        entrenamiento.setRutina(rutina);
        entrenamiento.setFechaInicio(dto.fechaInicio());
        entrenamiento.setFechaFin(dto.fechaFin());
        entrenamiento.setDuracion(dto.duracion());
        entrenamiento.setVolumenTotal(dto.volumenTotal());
        return convertirDTO(
                entrenamientoRepository.save(entrenamiento)
        );

    }

    public List<EntrenamientoResponseDTO> listar(){
        return entrenamientoRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();

    }

    public EntrenamientoResponseDTO buscar(Long id){
        EntrenamientoEntity entrenamiento =
                entrenamientoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Entrenamiento no encontrado")
                        );
        return convertirDTO(entrenamiento);

    }

    public EntrenamientoResponseDTO actualizar(
            Long id,
            EntrenamientoRequestDTO dto
    ){

        EntrenamientoEntity entrenamiento =
                entrenamientoRepository.findById(id)
                        .orElseThrow();
        UsuarioEntity usuario =
                usuarioRepository.findById(dto.idUsuario())
                        .orElseThrow();

        RutinaEntity rutina = null;
        if(dto.idRutina()!=null){
            rutina =
                    rutinaRepository.findById(dto.idRutina())
                            .orElseThrow();

        }
        entrenamiento.setUsuario(usuario);
        entrenamiento.setRutina(rutina);
        entrenamiento.setFechaInicio(dto.fechaInicio());
        entrenamiento.setFechaFin(dto.fechaFin());
        entrenamiento.setDuracion(dto.duracion());
        entrenamiento.setVolumenTotal(dto.volumenTotal());
        return convertirDTO(
                entrenamientoRepository.save(entrenamiento)
        );
    }

    public void eliminar(Long id){
        entrenamientoRepository.deleteById(id);
    }

    private EntrenamientoResponseDTO convertirDTO(
            EntrenamientoEntity e
    ){
        return new EntrenamientoResponseDTO(
                e.getIdEntrenamiento(),
                e.getUsuario().getIdUsuario(),
                e.getRutina()!=null ?
                        e.getRutina().getIdRutina()
                        : null,
                e.getFechaInicio(),
                e.getFechaFin(),
                e.getDuracion(),
                e.getVolumenTotal()

        );

    }


}