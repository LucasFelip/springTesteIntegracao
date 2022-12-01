CREATE TABLE cidade
(
    codigo_cidade INT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(30)        NULL,
    uf            VARCHAR(2)         NULL,
    taxa          FLOAT              NOT NULL,
    CONSTRAINT pk_cidade PRIMARY KEY (codigo_cidade)
);

CREATE TABLE cliente
(
    codigo_cliente INT AUTO_INCREMENT NOT NULL,
    nome           VARCHAR(30)        NULL,
    telefone       VARCHAR(30)        NULL,
    endereco       VARCHAR(30)        NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (codigo_cliente)
);

CREATE TABLE frete
(
    codigo_frete   INT AUTO_INCREMENT NOT NULL,
    codigo_cliente INT                NULL,
    codigo_cidade  INT                NULL,
    descricao      VARCHAR(30)        NULL,
    peso           FLOAT              NOT NULL,
    valcr          FLOAT              NOT NULL,
    CONSTRAINT pk_frete PRIMARY KEY (codigo_frete)
);

ALTER TABLE frete
    ADD CONSTRAINT FK_FRETE_ON_CODIGO_CIDADE FOREIGN KEY (codigo_cidade) REFERENCES cidade (codigo_cidade);

ALTER TABLE frete
    ADD CONSTRAINT FK_FRETE_ON_CODIGO_CLIENTE FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente);