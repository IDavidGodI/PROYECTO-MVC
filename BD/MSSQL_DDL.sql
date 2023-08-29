CREATE DATABASE UCC;

USE UCC;

CREATE TABLE PROFESOR(
	ID_PROFESOR INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	CORREO VARCHAR(75) UNIQUE NOT NULL,
	CLAVE VARCHAR(64) NOT NULL,
	NOMBRE VARCHAR(75) NOT NULL
);

CREATE TABLE CURSO(
	COD_CURSO VARCHAR(3) NOT NULL PRIMARY KEY,
	ID_PROFESOR INT,
	NOMBRE_CURSO VARCHAR(50) NOT NULL,
	HORA_INICIO TIME,
	HORA_FIN TIME,

	FOREIGN KEY (ID_PROFESOR) REFERENCES PROFESOR(ID_PROFESOR)
);

CREATE TABLE ESTUDIANTE(
	CC_ESTUDIANTE VARCHAR(3) PRIMARY KEY,
	NOMBRE VARCHAR(75) NOT NULL
);

CREATE TABLE INSCRIPCION_CURSO(
	COD_CURSO VARCHAR(3),
	CC_ESTUDIANTE VARCHAR(3),
	NOTA FLOAT

	FOREIGN KEY (COD_CURSO) REFERENCES CURSO(COD_CURSO),
	FOREIGN KEY (CC_ESTUDIANTE) REFERENCES ESTUDIANTE(CC_ESTUDIANTE),

	PRIMARY KEY (COD_CURSO, CC_ESTUDIANTE)
	
);