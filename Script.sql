CREATE DATABASE entremente;

CREATE TABLE PACIENTE (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(40),
    apellidos VARCHAR(40),
    documentoIdentidad VARCHAR(15),
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
    documentoIdentidad VARCHAR(15),
    nombreUsuario VARCHAR(50),
    password VARCHAR(50),
    tipoDocumento CHAR(1),
	correo VARCHAR(80)
);

CREATE TABLE PERSONALSALUD (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(40),
    apellidos VARCHAR(40),
    documentoIdentidad VARCHAR(15),
    nombreUsuario VARCHAR(50),
    password VARCHAR(50),
    tipoDocumento CHAR(1),
	correo VARCHAR(80),
    rol VARCHAR(2) 
);

CREATE TABLE PACIENTEFAMILIAR (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idFamiliar INT UNSIGNED NOT NULL,
    FOREIGN KEY (idPaciente) REFERENCES paciente(id),
    FOREIGN KEY (idFamiliar) REFERENCES FAMILIAR(id),
    estado VARCHAR(2), /* P = Pendiente   /  A = Aceptado*/
    relacion VARCHAR(20), 
	enviado VARCHAR(1) /* P = Paciente   /  O = Otro*/
);

CREATE TABLE PACIENTESALUD (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPersonalSalud INT UNSIGNED NOT NULL,
    FOREIGN KEY (idPaciente) REFERENCES paciente(id),
    FOREIGN KEY (idPersonalSalud) REFERENCES PERSONALSALUD(id),
    estado VARCHAR(2),/* P = Pendiente   /  A = Aceptado*/
    relacion VARCHAR(20),
	enviado VARCHAR(1)/* P = Paciente   /  O = Otro*/
);

CREATE TABLE MENSAJES (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPersonalSalud INT UNSIGNED,
	idFamiliar INT UNSIGNED,
	fecha DATE,
	mensaje VARCHAR(2000),
	tipo VARCHAR(20),
	rol VARCHAR(20),
	puedeVerPac VARCHAR(1),/* S = Si   /  N = No*/
    FOREIGN KEY (idPaciente) REFERENCES paciente(id),
    FOREIGN KEY (idPersonalSalud) REFERENCES PERSONALSALUD(id),
	FOREIGN KEY (idFamiliar) REFERENCES FAMILIAR(id)
);
ALTER TABLE `entremente`.`MENSAJES`
ADD INDEX `FK_MenPac_idx` (`idFamiliar` ASC),
ADD INDEX `FK_MenPS_idx` (`idPersonalSalud` ASC);
ALTER TABLE `entremente`.`MENSAJES`
ADD CONSTRAINT `FK_MenPac`
  FOREIGN KEY (`idFamiliar`)
  REFERENCES `entremente`.`FAMILIAR` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_MenPS`
  FOREIGN KEY (`idPersonalSalud`)
  REFERENCES `entremente`.`PACIENTESALUD` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_MenFam`
  FOREIGN KEY (`idFamiliar`)
  REFERENCES `entremente`.`FAMILIAR` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE ENFERMEDAD (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20),
	codigo VARCHAR(20)
);  
  
 CREATE TABLE HISTORIALMEDICO (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idEnfermedad INT UNSIGNED NOT NULL,
    idPersonalSalud INT UNSIGNED NOT NULL,
	fecha DATE
); 

ALTER TABLE `entremente`.`HISTORIALMEDICO`
ADD INDEX `FK_HMPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_HMEnf_idx` (`idEnfermedad` ASC);
ALTER TABLE `entremente`.`HISTORIALMEDICO`
ADD CONSTRAINT `FK_HMPac`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_HMEnf`
  FOREIGN KEY (`idEnfermedad`)
  REFERENCES `entremente`.`ENFERMEDAD` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_HMPS`
  FOREIGN KEY (`idPersonalSalud`)
  REFERENCES `entremente`.`PERSONALSALUD` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
   
  

