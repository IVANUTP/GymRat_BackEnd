package com.gymRat.gymRatBackEnd.domain.rutinas;

import com.gymRat.gymRatBackEnd.domain.objetivo.ObjetivoEntity;
import com.gymRat.gymRatBackEnd.domain.objetivo.ObjetivoRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaRequestDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.DTO.RutinaResponseDTO;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.RutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.entity.TipoRutinaEntity;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.RutinaRepository;
import com.gymRat.gymRatBackEnd.domain.rutinas.repository.TipoRutinaRepository;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    private final RutinaRepository rutinaRepository;
    private final TipoRutinaRepository tipoRutinaRepository;
    private final ObjetivoRepository objetivoRepository;
    private final UsuarioRepository usuarioRepository;

    public RutinaService(
            RutinaRepository rutinaRepository,
            TipoRutinaRepository tipoRutinaRepository,
            ObjetivoRepository objetivoRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.rutinaRepository = rutinaRepository;
        this.tipoRutinaRepository = tipoRutinaRepository;
        this.objetivoRepository = objetivoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public RutinaResponseDTO guardar(RutinaRequestDTO dto) {

        UsuarioEntity usuario = null;
        if (dto.idUsuario() != null) {
            usuario = usuarioRepository.findById(dto.idUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        ObjetivoEntity objetivo = objetivoRepository.findById(dto.idObjetivo())
                .orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));

        TipoRutinaEntity tipo = tipoRutinaRepository.findById(dto.idTipoRutina())
                .orElseThrow(() -> new RuntimeException("Tipo rutina no encontrado"));

        RutinaEntity rutina = new RutinaEntity();
        rutina.setUsuario(usuario);
        rutina.setObjetivo(objetivo);
        rutina.setTipoRutina(tipo);
        rutina.setNombre(dto.nombre());
        rutina.setDescripcion(dto.descripcion());
        rutina.setEsPlantilla(dto.esPlantilla() != null ? dto.esPlantilla() : false);

        return convertir(rutinaRepository.save(rutina));
    }
    public RutinaResponseDTO actualizar(Long id, RutinaRequestDTO dto) {

        RutinaEntity rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (dto.idUsuario() != null) {
            UsuarioEntity usuario = usuarioRepository.findById(dto.idUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            rutina.setUsuario(usuario);
        }

        if (dto.idObjetivo() != null) {
            ObjetivoEntity objetivo = objetivoRepository.findById(dto.idObjetivo())
                    .orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
            rutina.setObjetivo(objetivo);
        }

        if (dto.idTipoRutina() != null) {
            TipoRutinaEntity tipo = tipoRutinaRepository.findById(dto.idTipoRutina())
                    .orElseThrow(() -> new RuntimeException("Tipo rutina no encontrado"));
            rutina.setTipoRutina(tipo);
        }

        rutina.setNombre(dto.nombre());
        rutina.setDescripcion(dto.descripcion());

        return convertir(rutinaRepository.save(rutina));
    }

    public List<RutinaResponseDTO> listar() {
        return rutinaRepository.findAll()
                .stream()
                .map(this::convertir)
                .toList();
    }

    public RutinaResponseDTO buscar(Long id) {
        RutinaEntity rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
        return convertir(rutina);
    }

    public void eliminar(Long id) {
        if (!rutinaRepository.existsById(id)) {
            throw new RuntimeException("Rutina no encontrada");
        }
        rutinaRepository.deleteById(id);
    }

    private RutinaResponseDTO convertir(RutinaEntity rutina) {
        Long idUsuario = rutina.getUsuario() != null ? rutina.getUsuario().getIdUsuario() : null;
        String nombreUsuario = rutina.getUsuario() != null ? rutina.getUsuario().getNombre() : null;

        return new RutinaResponseDTO(
                rutina.getIdRutina(),
                idUsuario,
                nombreUsuario,
                rutina.getObjetivo().getIdObjetivo(),
                rutina.getObjetivo().getNombre(),
                rutina.getTipoRutina().getIdTipoRutina(),
                rutina.getTipoRutina().getNombre(),
                rutina.getNombre(),
                rutina.getDescripcion(),
                rutina.getEsPlantilla(), // ← corregido: era isEsPlantilla()
                rutina.getFechaCreacion()
        );
    }
}