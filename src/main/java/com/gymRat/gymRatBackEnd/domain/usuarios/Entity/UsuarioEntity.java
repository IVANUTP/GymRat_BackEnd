package com.gymRat.gymRatBackEnd.domain.usuarios.Entity;

import com.gymRat.gymRatBackEnd.domain.recomendacion.entity.Nivel;
import com.gymRat.gymRatBackEnd.domain.rol.entity.RolEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "foto_perfil", length = 500)
    private String fotoPerfil;

    @Column(name = "peso_actual", precision = 5, scale = 2)
    private BigDecimal pesoActual;

    @Column(name = "peso_objetivo", precision = 5, scale = 2)
    private BigDecimal pesoObjetivo;

    @Column(precision = 5, scale = 2)
    private BigDecimal altura;

    private LocalDate fechaNacimiento;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }
}