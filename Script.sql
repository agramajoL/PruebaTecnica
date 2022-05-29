CREATE TABLE INSCRIPCION(
	CARNET VARCHAR2(6 CHAR) PRIMARY KEY,
	NOMBRE VARCHAR2(100 CHAR) NOT NULL,
	DIRECCION VARCHAR2(200 CHAR) NOT NULL,
	GENERO VARCHAR2(9 CHAR) NOT NULL,
	TELEFONO NUMBER(8,0) NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL,
	FECHA_INSCRIPCION DATE NOT NULL,
	GENERO_POESIA VARCHAR2(10 CHAR) NOT NULL,
	FECHA_DECLAMACION DATE NOT NULL,
	CARRERA VARCHAR2(200 CHAR) NOT NULL
	
);

ALTER TABLE INSCRIPCION
ADD CONSTRAINT GENERO_VALIDOS CHECK(GENERO IN ('Masculino', 'Femenino'));

ALTER TABLE INSCRIPCION
ADD CONSTRAINT GENERO_POESIA_VALIDOS CHECK(GENERO_POESIA IN ('Dramatico', 'Epico', 'Lirica'));

ALTER TABLE INSCRIPCION 
ADD CONSTRAINT CARNET_VALIDO CHECK(REGEXP_LIKE(CARNET, '^[aA][a-zA-Z1-9]5[a-zA-Z1-9]{2}[139]$'))

ALTER TABLE INSCRIPCION 
DROP CONSTRAINT genero_poesia_validos;

SELECT * FROM INSCRIPCION;


INSERT INTO INSCRIPCION(CARNET, NOMBRE, DIRECCION, GENERO, TELEFONO, FECHA_NACIMIENTO, FECHA_INSCRIPCION, FECHA_DECLAMACION, GENERO_POESIA, CARRERA)
VALUES('AE5BZ9', 'ALAN BARTOLOMEO DE LAS PUERTAS IXPUC', 'BLAH BLAH', 'Masculino', 12344321, TO_DATE('30/12/2022', 'DD/MM/YYYY'), TO_DATE('30/12/2022', 'DD/MM/YYYY'),TO_DATE('30/12/2022', 'DD/MM/YYYY'), 'Lirica', 'Sistemas');

SELECT TO_CHAR(fecha_nacimiento, 'dd/mm/yyyy') FROM inscripcion; 

TRUNCATE TABLE INSCRIPCION;

--DROP TABLE INSCRIPCION;