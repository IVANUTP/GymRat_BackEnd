ALTER TABLE tbl_rutinas
    ADD COLUMN id_objetivo BIGINT NOT NULL;

ALTER TABLE tbl_rutinas
    ADD CONSTRAINT fk_rutina_objetivo
        FOREIGN KEY (id_objetivo)
            REFERENCES tbl_objetivos_rutina(id_objetivo);