CREATE TABLE tbl_ejercicios (
                                id_ejercicio BIGSERIAL PRIMARY KEY,

                                nombre VARCHAR(150) NOT NULL,

                                grupo_muscular VARCHAR(100) NOT NULL,

                                descripcion TEXT,

                                imagen VARCHAR(500),

                                fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                activo BOOLEAN DEFAULT TRUE
);