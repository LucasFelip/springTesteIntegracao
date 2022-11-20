-- cidade and fretes
CREATE TABLE cidade_fretes (
  `codigo_frete` INT NOT NULL,
   codigo_cidade INT NOT NULL
);

ALTER TABLE cidade_fretes ADD CONSTRAINT uc_cidade_fretes__codigo_frete UNIQUE (codigo_frete);

ALTER TABLE cidade_fretes ADD CONSTRAINT fk_cidfre_on_cidade FOREIGN KEY (codigo_cidade) REFERENCES cidade (codigo_cidade);

ALTER TABLE cidade_fretes ADD CONSTRAINT fk_cidfre_on_frete FOREIGN KEY (codigo_frete) REFERENCES frete (codigo_frete);

-- cliente and fretes
CREATE TABLE cliente_fretes (
  `codigo_frete` INT NOT NULL,
   codigo_cliente INT NOT NULL
);

ALTER TABLE cliente_fretes ADD CONSTRAINT uc_cliente_fretes__codigo_frete UNIQUE (codigo_frete);

ALTER TABLE cliente_fretes ADD CONSTRAINT fk_clifre_on_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente);

ALTER TABLE cliente_fretes ADD CONSTRAINT fk_clifre_on_frete FOREIGN KEY (codigo_frete) REFERENCES frete (codigo_frete);