CREATE TABLE cliente (
  codigo_cliente INT NOT NULL,
   nome VARCHAR(30) NULL,
   telefone VARCHAR(30) NULL,
   endereco VARCHAR(30) NULL,
   CONSTRAINT pk_cliente PRIMARY KEY (codigo_cliente)
);