CREATE TABLE tbl_fotos (
                           id BIGSERIAL PRIMARY KEY,

                           id_usuario BIGINT NOT NULL,

                           url VARCHAR(500) NOT NULL,

                           fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                           CONSTRAINT fk_foto_usuario
                               FOREIGN KEY (id_usuario)
                                   REFERENCES tbl_usuarios(id_usuario)
                                   ON DELETE CASCADE
);