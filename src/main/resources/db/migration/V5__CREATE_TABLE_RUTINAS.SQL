CREATE TABLE tbl_rutinas (
                             id_rutina BIGSERIAL PRIMARY KEY,

                             id_usuario BIGINT NOT NULL,

                             nombre VARCHAR(150) NOT NULL,

                             descripcion TEXT,

                             fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT fk_rutina_usuario
                                 FOREIGN KEY (id_usuario)
                                     REFERENCES tbl_usuarios(id_usuario)
                                     ON DELETE CASCADE
);