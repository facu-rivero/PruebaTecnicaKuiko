CREATE TABLE COMUNIDADES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CODIGO_CA VARCHAR(5) UNIQUE,
    NOMBRE_CA VARCHAR(100) NOT NULL
    );

CREATE TABLE PROVINCIAS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CODIGO_PROVINCIA INT NOT NULL ,
    NOMBRE_PROVINCIA VARCHAR(100) NOT NULL,
    CODIGO_CA VARCHAR(5) NOT NULL,
    FOREIGN KEY (CODIGO_CA) REFERENCES COMUNIDADES(CODIGO_CA)
    );