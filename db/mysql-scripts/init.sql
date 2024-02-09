CREATE DATABASE IF NOT EXISTS db_post;
USE db_post;

CREATE TABLE categoria
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    nombre              VARCHAR(150),
    fecha_creacion      TIMESTAMP,
    fecha_actualizacion TIMESTAMP
);

INSERT INTO categoria (nombre, fecha_creacion, fecha_actualizacion)
VALUES ('Categoria1', '2024-02-08 00:00:00', '2024-02-08 00:00:00'),
       ('Categoria2', '2024-02-08 00:00:00', '2024-02-08 00:00:00');


CREATE TABLE IF NOT EXISTS post
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    titulo              VARCHAR(150),
    contenido           TEXT,
    fecha_creacion      TIMESTAMP,
    fecha_actualizacion TIMESTAMP,
    categoria_id        INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

-- Agregar datos de prueba a la tabla POST
INSERT INTO post (titulo, contenido, fecha_creacion, fecha_actualizacion, categoria_id)
VALUES ('Titulo1', 'Contenido1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
       ('Titulo2', 'Contenido2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);

-- Crear la tabla COMENTARIO
CREATE TABLE IF NOT EXISTS comentario
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    contenido           VARCHAR(250),
    fecha_creacion      TIMESTAMP,
    fecha_actualizacion TIMESTAMP,
    post_id             INT,
    FOREIGN KEY (post_id) REFERENCES post (id)
);

-- Agregar datos de prueba a la tabla COMENTARIO
INSERT INTO comentario (contenido, fecha_creacion, fecha_actualizacion, post_id)
VALUES ('Contenido comentario 1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
       ('Contenido comentario 2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
