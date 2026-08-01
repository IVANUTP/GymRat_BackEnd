ALTER TABLE tbl_rutinas
    ADD COLUMN id_tipo_rutina BIGINT NOT NULL;

ALTER TABLE tbl_rutinas
    ADD CONSTRAINT fk_rutina_tipo_rutina
        FOREIGN KEY (id_tipo_rutina) REFERENCES tbl_tipo_rutina(id_tipo_rutina);