CREATE TABLE IF NOT EXISTS atividade (
	id bigint NOT NULL,
	ch_maxima integer NOT NULL,
	descricao varchar(255),
	eixo varchar(255),
	PRIMARY KEY (id)	
);


CREATE TABLE IF NOT EXISTS curso(
	id bigint NOT NULL,
	horas_complementares integer NOT NULL,
	nome varchar(255),
	PRIMARY KEY (id)	
);