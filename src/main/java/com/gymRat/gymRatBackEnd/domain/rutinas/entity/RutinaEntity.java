package com.gymRat.gymRatBackEnd.domain.rutinas.entity;

import com.gymRat.gymRatBackEnd.domain.objetivo.ObjetivoEntity;
import com.gymRat.gymRatBackEnd.domain.usuarios.Entity.UsuarioEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_rutinas")
public class RutinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Long idRutina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = true) // ahora nullable, para plantillas
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_objetivo", nullable = false)
    private ObjetivoEntity objetivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_rutina", nullable = false)
    private TipoRutinaEntity tipoRutina;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "es_plantilla")
    private Boolean esPlantilla = false;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.esPlantilla == null) {
            this.esPlantilla = false;
        }
    }

    public RutinaEntity() {}

    public Long getIdRutina() { return idRutina; }
    public void setIdRutina(Long idRutina) { this.idRutina = idRutina; }

    public UsuarioEntity getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntity usuario) { this.usuario = usuario; }

    public ObjetivoEntity getObjetivo() { return objetivo; }
    public void setObjetivo(ObjetivoEntity objetivo) { this.objetivo = objetivo; }

    public TipoRutinaEntity getTipoRutina() { return tipoRutina; }
    public void setTipoRutina(TipoRutinaEntity tipoRutina) { this.tipoRutina = tipoRutina; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Boolean getEsPlantilla() { return esPlantilla; }
    public void setEsPlantilla(Boolean esPlantilla) { this.esPlantilla = esPlantilla; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}