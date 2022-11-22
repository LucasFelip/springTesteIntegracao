CREATE TABLE cidade (
  codigo_cidade INT NOT NULL AUTO_INCREMENT,
   nome VARCHAR(30) NULL,
   uf VARCHAR(2) NULL,
   taxa FLOAT NOT NULL,
   CONSTRAINT pk_cidade PRIMARY KEY (codigo_cidade)
);