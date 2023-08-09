USE UCC;

INSERT INTO PROFESOR(CC_PROFESOR, NOMBRE_PROFESOR, CORREO) VALUES ("190", "Alberto Torres", "albertot@gmail.com");
INSERT INTO PROFESOR(CC_PROFESOR, NOMBRE_PROFESOR, CORREO) VALUES ("230", "Juan Perez", "juanito32@gmail.com");

INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (20, "Matematicas Especiales", "190", "7:00","10:00");
INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (30, "Calculo Diferencial", "190", "12:00","13:30");
INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (40, "Estadistica Inferencial", "190", "10:00","12:00");

INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (90, "Introduccion a la geologia marina", "230", "10:00","12:00");
INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (80, "Estadistica general y bioestadistica", "230", "10:00","12:00");
INSERT INTO ING_SISTEMAS(COD_CURSO, NOMBRE_CURSO, CC_PROFESOR, HORA_INICIO, HORA_FIN) VALUES (70, "Fisica General", "230", "10:00","12:00");

INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("300", "Pablo Langosta", 5, 90);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("410", "Juan Alberto", 4.9, 90);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("420", "Lars Cameron", 4.6, 90);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("430", "Kujo Jotaro", 4.8, 90);

INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("510", "Jose Villanueva", 4.6, 80);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("520", "Alberto Villavieja", 3.2, 80);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("530", "Indalecio Hetfield", 4.9, 80);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("540", "Ruben Garcia", 4.6, 80);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("550", "Rocio Veracruz", 4.8, 80);


INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("310", "Ivan Manrique", 4, 20);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("323", "Raul Garcia", 3.5, 20);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("335", "Ana Acosta", 1, 20);

INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("456", "Rosa m", 4.2, 30);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("450", "Roberto Patiño", 3, 30);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("356", "Maria Esperanza de la Cruz", 2.9, 30);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("500", "Pablo.", 5, 30);

INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("460", "Gonzalo González", 3.5, 40);
INSERT INTO ESTUDIANTE(CC_ESTUDIANTE, NOMBRE_ESTUDIANTE, NOTA, COD_CURSO) VALUES ("440", "Pablo Whitney", 5, 40);
