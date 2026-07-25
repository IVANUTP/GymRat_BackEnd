CREATE TABLE tbl_peso (
                          id BIGSERIAL PRIMARY KEY,

                          id_usuario BIGINT NOT NULL,

                          peso DECIMAL(5,2) NOT NULL,

                          fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT fk_peso_usuario
                              FOREIGN KEY (id_usuario)
                                  REFERENCES tbl_usuarios(id_usuario)
                                  ON DELETE CASCADE
);