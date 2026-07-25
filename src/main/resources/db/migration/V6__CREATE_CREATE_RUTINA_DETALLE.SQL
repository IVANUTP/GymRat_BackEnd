CREATE TABLE tbl_rutina_detalle (
                                    id BIGSERIAL PRIMARY KEY,

                                    id_rutina BIGINT NOT NULL,

                                    id_ejercicio BIGINT NOT NULL,

                                    series INT NOT NULL,

                                    repeticiones INT NOT NULL,

                                    descanso INT,

                                    orden INT NOT NULL,

                                    CONSTRAINT fk_detalle_rutina
                                        FOREIGN KEY (id_rutina)
                                            REFERENCES tbl_rutinas(id_rutina)
                                            ON DELETE CASCADE,

                                    CONSTRAINT fk_detalle_ejercicio
                                        FOREIGN KEY (id_ejercicio)
                                            REFERENCES tbl_ejercicios(id_ejercicio)
);