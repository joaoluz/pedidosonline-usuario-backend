-- Cria Banco de dados
CREATE DATABASE pedidosonline;

-- Cria schema usuario;

CREATE SCHEMA usuario AUTHORIZATION postgres;

-- usuario.usuario definition

CREATE TABLE usuario.usuario (
	id_usuario serial NOT NULL,
	no_usuario varchar NOT NULL,
	email varchar NOT NULL,
	senha varchar NOT NULL,
	dt_aniversario date NOT NULL,
	nr_ddd numeric NOT NULL,
	nr_telefone numeric NOT NULL,
	nr_cpf varchar NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);

-- usuario.endereco definition

CREATE TABLE usuario.endereco (
	id_endereco serial NOT NULL,
	logradouro varchar NOT NULL,
	cep varchar NOT NULL,
	bairro varchar NOT NULL,
	complemento varchar NULL,
	numero varchar NOT NULL,
	CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- usuario.endereco_usuario definition

CREATE TABLE usuario.endereco_usuario (
	id_usuario int4 NOT NULL,
	id_endereco int4 NOT NULL,
    CONSTRAINT endereco_usuario_endereco_fk FOREIGN KEY (id_endereco) REFERENCES usuario.endereco(id_endereco),
    CONSTRAINT endereco_usuario_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario.usuario(id_usuario)
);

-- DROP SCHEMA pedido;

CREATE SCHEMA pedido AUTHORIZATION postgres;

CREATE TABLE pedido.categoria (
	id_categoria serial NOT NULL,
	no_categoria varchar NOT NULL,
	id_categoria_pai integer NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (id_categoria),
	CONSTRAINT categoria_categoria_fk FOREIGN KEY (id_categoria_pai) REFERENCES pedido.categoria(id_categoria)
);

-- pedido.produto definition

CREATE TABLE pedido.produto (
	id_produto serial NOT NULL,
	no_produto varchar NOT NULL,
	vl_compra float4 NOT NULL,
	vl_venda float4 NOT NULL,
	ds_produto varchar NOT NULL,
	vl_promocao float4 NULL,
	no_imagem varchar NULL,
    id_categoria integer NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id_produto),
    CONSTRAINT produto_categoria_fk FOREIGN KEY (id_categoria) REFERENCES pedido.categoria(id_categoria)
);

-- pedido.forma_pagamento definition

CREATE TABLE pedido.forma_pagamento (
	id_forma_pagamento serial NOT NULL,
	no_forma_pagamento varchar NULL,
	CONSTRAINT forma_pagamento_pk PRIMARY KEY (id_forma_pagamento)
);

-- pedido.pedido definition

CREATE TABLE pedido.pedido (
	id_pedido serial4 NOT NULL,
	id_usuario int4 NOT NULL,
	dt_pedido timestamp NOT NULL,
	id_endereco int4 NOT NULL,
	st_pedido bpchar(1) NOT NULL,
	pr_entrega_inicial time NOT NULL,
	pr_entrega_final time NOT NULL,
	id_forma_pagamento int4 NOT NULL,
	CONSTRAINT pedido_pk PRIMARY KEY (id_pedido),
	CONSTRAINT pedido_endereco_fk FOREIGN KEY (id_endereco) REFERENCES usuario.endereco(id_endereco),
	CONSTRAINT pedido_forma_pagamento_fk FOREIGN KEY (id_forma_pagamento) REFERENCES pedido.forma_pagamento(id_forma_pagamento),
	CONSTRAINT pedido_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario.usuario(id_usuario)
);

-- pedido.pedido_produto definition

CREATE TABLE pedido.pedido_produto (
	id_pedido_produto serial NOT NULL,
	id_pedido integer NOT NULL,
	id_produto integer NOT NULL,
	nr_quantidade integer NOT NULL,
	observacao varchar NULL,
	CONSTRAINT pedido_produto_pk PRIMARY KEY (id_pedido_produto),
	CONSTRAINT pedido_produto_produto_fk FOREIGN KEY (id_produto) REFERENCES pedido.produto(id_produto),
	CONSTRAINT pedido_produto_pedido_fk FOREIGN KEY (id_pedido) REFERENCES pedido.pedido(id_pedido)
);
