CREATE TABLE tbl_recomendacion_rutina (
                                          id_recomendacion BIGSERIAL PRIMARY KEY,
                                          id_objetivo BIGINT,
                                          id_tipo_rutina BIGINT,
                                          id_nivel SMALLINT,
                                          dias_min SMALLINT,
                                          dias_max SMALLINT,
                                          prioridad SMALLINT,
                                          FOREIGN KEY (id_objetivo) REFERENCES tbl_objetivos_rutina(id_objetivo),
                                          FOREIGN KEY (id_tipo_rutina) REFERENCES tbl_tipo_rutina(id_tipo_rutina),
                                          FOREIGN KEY (id_nivel) REFERENCES tbl_niveles(id_nivel)
);