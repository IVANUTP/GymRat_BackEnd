CREATE TABLE tbl_entrenamiento_detalle (
                                           id BIGSERIAL PRIMARY KEY,

                                           id_entrenamiento BIGINT NOT NULL,

                                           id_ejercicio BIGINT NOT NULL,

                                           serie INT NOT NULL,

                                           peso DECIMAL(6,2),

                                           repeticiones INT NOT NULL,

                                           rir INT,

                                           CONSTRAINT fk_detalle_entrenamiento
                                               FOREIGN KEY (id_entrenamiento)
                                                   REFERENCES tbl_entrenamientos(id_entrenamiento)
                                                   ON DELETE CASCADE,

                                           CONSTRAINT fk_detalle_ejercicio
                                               FOREIGN KEY (id_ejercicio)
                                                   REFERENCES tbl_ejercicios(id_ejercicio)
);