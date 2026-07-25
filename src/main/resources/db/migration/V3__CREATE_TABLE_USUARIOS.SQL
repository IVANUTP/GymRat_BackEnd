CREATE TABLE tbl_usuarios(
                             id_usuario BIGSERIAL PRIMARY KEY,

                             id_rol BIGINT NOT NULL,

                             nombre VARCHAR(100) NOT NULL,
                             correo VARCHAR(150) NOT NULL UNIQUE,
                             password VARCHAR(255) NOT NULL,

                             foto_perfil VARCHAR(500),

                             peso_actual DECIMAL(5,2),
                             peso_objetivo DECIMAL(5,2),
                             altura DECIMAL(5,2),

                             fecha_nacimiento DATE,

                             fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT fk_usuario_rol
                                 FOREIGN KEY (id_rol)
                                     REFERENCES tbl_roles(id_rol)
)