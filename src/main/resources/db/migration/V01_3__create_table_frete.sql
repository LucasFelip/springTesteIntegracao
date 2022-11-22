CREATE TABLE frete (
  codigo_frete INT NOT NULL AUTO_INCREMENT,
   codigo_cliente INT NULL,
   codigo_cidade INT NULL,
   descricao VARCHAR(30) NULL,
   peso FLOAT NOT NULL,
   valcr FLOAT NOT NULL,
   CONSTRAINT pk_frete PRIMARY KEY (codigo_frete)
);

ALTER TABLE frete ADD CONSTRAINT FK_FRETE_ON_CODIGO_CIDADE FOREIGN KEY (codigo_cidade) REFERENCES cidade (codigo_cidade);

ALTER TABLE frete ADD CONSTRAINT FK_FRETE_ON_CODIGO_CLIENTE FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente);