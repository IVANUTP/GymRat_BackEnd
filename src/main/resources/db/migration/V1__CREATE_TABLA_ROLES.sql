CREATE TABLE tbl_roles (
                           id_rol BIGSERIAL PRIMARY KEY,
                           nombre VARCHAR(50) NOT NULL UNIQUE,
                           descripcion VARCHAR(150)
);