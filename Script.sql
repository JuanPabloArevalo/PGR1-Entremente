CREATE DATABASE entremente;

CREATE TABLE paciente (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(40),
    apellidos VARCHAR(40),
    documentoIdentidad VARCHAR(10),
    fechaNacimiento DATE,
    genero CHAR(1),
    pais VARCHAR(15),
    ciudad VARCHAR(15),
    nombreUsuario VARCHAR(50),
    password VARCHAR(50),
    direccion VARCHAR(100),
    tipoDocumento CHAR(1),
	correo VARCHAR(80)
);

CREATE TABLE FAMILIAR (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(40),
    apellidos VARCHAR(40),
    documentoIdentidad VARCHAR(10),
    nombreUsuario VARCHAR(50),
    password VARCHAR(50),
    tipoDocumento CHAR(1),
	correo VARCHAR(80)
);

