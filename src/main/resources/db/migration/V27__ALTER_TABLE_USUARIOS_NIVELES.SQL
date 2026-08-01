-- 3. Agregar la columna en tbl_usuarios (si ya la agregaste, saltate este paso)
ALTER TABLE tbl_usuarios ADD COLUMN id_nivel SMALLINT DEFAULT 1;
-- 4. Agregar la Foreign Key
ALTER TABLE tbl_usuarios
    ADD CONSTRAINT fk_usuario_nivel
        FOREIGN KEY (id_nivel) REFERENCES tbl_niveles(id_nivel);

