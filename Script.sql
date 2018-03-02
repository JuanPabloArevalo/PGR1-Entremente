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
	fecha DATE,
	rol VARCHAR(20)
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

 CREATE TABLE PREGUNTAGALERIA (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	pregunta VARCHAR(500),
	imagen VARCHAR(1500),
	informacion VARCHAR(3000),
	opcionA VARCHAR(80),
	opcionB VARCHAR(80),
	opcionC VARCHAR(80),
	opcionD VARCHAR(80),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1)
);   
  
 CREATE TABLE JUEGOGALERIAPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaGaleria INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOGALERIAPACIENTE`
ADD INDEX `FK_JGPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JGPPG_idx` (`idPreguntaGaleria` ASC);
ALTER TABLE `entremente`.`JUEGOGALERIAPACIENTE`
ADD CONSTRAINT `FK_JGPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JGPPG`
  FOREIGN KEY (`idPreguntaGaleria`)
  REFERENCES `entremente`.`PREGUNTAGALERIA` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
CREATE TABLE PREGUNTAATENCION (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	pregunta VARCHAR(500),
	imagen VARCHAR(1500),
	palabraClave VARCHAR(50),
	opcionA VARCHAR(1500),
	opcionB VARCHAR(1500),
	opcionC VARCHAR(1500),
	opcionD VARCHAR(1500),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1),
    palabraClaveA VARCHAR(50),
    palabraClaveB VARCHAR(50),
    palabraClaveC VARCHAR(50),
    palabraClaveD VARCHAR(50)
);   
  
 CREATE TABLE JUEGOATENCIONPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaAtencion INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOATENCIONPACIENTE`
ADD INDEX `FK_JAPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JAPPAt_idx` (`idPreguntaAtencion` ASC);
ALTER TABLE `entremente`.`JUEGOATENCIONPACIENTE`
ADD CONSTRAINT `FK_JAPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JAPPAt`
  FOREIGN KEY (`idPreguntaAtencion`)
  REFERENCES `entremente`.`PREGUNTAATENCION` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
 CREATE TABLE PREGUNTAFORMAS (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	pregunta VARCHAR(500),
	imagen VARCHAR(1500),
	opcionA VARCHAR(80),
	opcionB VARCHAR(80),
	opcionC VARCHAR(80),
	opcionD VARCHAR(80),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1)
);   
  
 CREATE TABLE JUEGOFORMASPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaFormas INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOFORMASPACIENTE`
ADD INDEX `FK_JFPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JFPPG_idx` (`idPreguntaGaleria` ASC);
ALTER TABLE `entremente`.`JUEGOFORMASPACIENTE`
ADD CONSTRAINT `FK_JFPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JFPPG`
  FOREIGN KEY (`idPreguntaFormas`)
  REFERENCES `entremente`.`PREGUNTAFORMAS` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;  
  
  
 CREATE TABLE PREGUNTAPERCEPCION (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	pregunta VARCHAR(500),
	imagen VARCHAR(1500),
	opcionA VARCHAR(80),
	opcionB VARCHAR(80),
	opcionC VARCHAR(80),
	opcionD VARCHAR(80),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1)
);   
  
 CREATE TABLE JUEGOPERCEPCIONPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaPercepcion INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOPERCEPCIONPACIENTE`
ADD INDEX `FK_JPPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JPPPG_idx` (`idPreguntaPercepcion` ASC);
ALTER TABLE `entremente`.`JUEGOPERCEPCIONPACIENTE`
ADD CONSTRAINT `FK_JPPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JPPPG`
  FOREIGN KEY (`idPreguntaPercepcion`)
  REFERENCES `entremente`.`PREGUNTAPERCEPCION` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;  
  
  
  
 CREATE TABLE PREGUNTACALCULO (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	operacion VARCHAR(500),
	opcionA VARCHAR(80),
	opcionB VARCHAR(80),
	opcionC VARCHAR(80),
	opcionD VARCHAR(80),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1)
);   
  
 CREATE TABLE JUEGOCALCULOPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaCalculo INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOCALCULOPACIENTE`
ADD INDEX `FK_JCPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JCPPG_idx` (`idPreguntaCalculo` ASC);
ALTER TABLE `entremente`.`JUEGOCALCULOPACIENTE`
ADD CONSTRAINT `FK_JCPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JCPPG`
  FOREIGN KEY (`idPreguntaCalculo`)
  REFERENCES `entremente`.`PREGUNTACALCULO` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;  
  
  
 CREATE TABLE RESULTADO (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	tipoJuego VARCHAR(1),
    idPaciente INT UNSIGNED NOT NULL,
	fecha DATE,
	acertadas INT(5),
    erroneas INT(5),
	tiempo DOUBLE,
	nivelMaximo INT(5)
); 

ALTER TABLE `entremente`.`RESULTADO`
ADD INDEX `FK_ResulPac_idx` (`idPaciente` ASC);
ALTER TABLE `entremente`.`RESULTADO`
ADD CONSTRAINT `FK_Respac`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;   
  
  
   CREATE TABLE PREGUNTAMUSICOTERAPIA (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	video VARCHAR(500),
    pregunta VARCHAR(500),
	opcionA VARCHAR(80),
	opcionB VARCHAR(80),
	opcionC VARCHAR(80),
	opcionD VARCHAR(80),
	nivelPredeterminado INT(5),
	personalizado VARCHAR(1),
	correctaA VARCHAR(1),
	correctaB VARCHAR(1),
	correctaC VARCHAR(1),
	correctaD VARCHAR(1)
);   
  
 CREATE TABLE JUEGOMUSICOTERAPIAPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaMusicoterapia INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOMUSICOTERAPIAPACIENTE`
ADD INDEX `FK_JMPPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JMPPM_idx` (`idPreguntaMusicoterapia` ASC);
ALTER TABLE `entremente`.`JUEGOMUSICOTERAPIAPACIENTE`
ADD CONSTRAINT `FK_JCPPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JCPPG`
  FOREIGN KEY (`idPreguntaMusicoterapia`)
  REFERENCES `entremente`.`PREGUNTAMUSICOTERAPIA` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;  
  
  
 CREATE TABLE PREGUNTAQUEUSAR (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    pregunta VARCHAR(500),
    imagen VARCHAR(500),
	nivelPredeterminado INT(5)
); 

 CREATE TABLE RESPUESTASQUEUSAR (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    imagen VARCHAR(500),
    idPregunta INT(8),
	esCorrecta VARCHAR(1)
); 

ALTER TABLE `entremente`.`RESPUESTASQUEUSAR`
ADD INDEX `FK_RQU_idx` (`idPregunta` ASC);
ALTER TABLE `entremente`.`RESPUESTASQUEUSAR`
ADD CONSTRAINT `FK_RQPQU`
  FOREIGN KEY (`idPregunta`)
  REFERENCES `entremente`.`PREGUNTAQUEUSAR` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION; 
  
  
   CREATE TABLE JUEGOQUEUSARPACIENTE (
	id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT UNSIGNED NOT NULL,
    idPreguntaQueUsar INT UNSIGNED NOT NULL,
    nivelPersonalizado INT(5),
	estado VARCHAR(1)
); 
  

ALTER TABLE `entremente`.`JUEGOQUEUSARPACIENTE`
ADD INDEX `FK_JQUPac_idx` (`idPaciente` ASC),
ADD INDEX `FK_JQUPM_idx` (`idPreguntaQueUsar` ASC);
ALTER TABLE `entremente`.`JUEGOQUEUSARPACIENTE`
ADD CONSTRAINT `FK_JQUPa`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `entremente`.`PACIENTE` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_JQUPQU`
  FOREIGN KEY (`idPreguntaQueUsar`)
  REFERENCES `entremente`.`PREGUNTAQUEUSAR` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION; 
  
  