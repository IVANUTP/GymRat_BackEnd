CREATE TABLE tbl_entrenamientos (
                                    id_entrenamiento BIGSERIAL PRIMARY KEY,

                                    id_usuario BIGINT NOT NULL,

                                    id_rutina BIGINT,

                                    fecha_inicio TIMESTAMP NOT NULL,

                                    fecha_fin TIMESTAMP,

                                    duracion INT,

                                    volumen_total DECIMAL(10,2),

                                    CONSTRAINT fk_entrenamiento_usuario
                                        FOREIGN KEY (id_usuario)
                                            REFERENCES tbl_usuarios(id_usuario)
                                            ON DELETE CASCADE,

                                    CONSTRAINT fk_entrenamiento_rutina
                                        FOREIGN KEY (id_rutina)
                                            REFERENCES tbl_rutinas(id_rutina)
);