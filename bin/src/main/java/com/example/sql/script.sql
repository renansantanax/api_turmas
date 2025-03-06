CREATE TABLE aluno (
	id				UUID			PRIMARY KEY,
	nome			VARCHAR(100)	NOT NULL,
	matricula		VARCHAR(50)		NOT NULL,
	cpf				VARCHAR(11)		NOT NULL
);

CREATE TABLE professor (
	id				UUID			PRIMARY KEY,
	nome			VARCHAR(100)	NOT NULL,
	telefone		VARCHAR(20)		NOT NULL
);

CREATE TABLE turma (
	id				UUID			PRIMARY KEY,
	nome			VARCHAR(50)		NOT NULL,
	data_inicio		DATE			NOT NULL,
	data_termino	DATE			NOT NULL,
	professor_id	UUID			NOT NULL,
	FOREIGN KEY (professor_id) REFERENCES professor(id)	
);

CREATE TABLE matricula (
	aluno_id		UUID 			NOT NULL,
	turma_id		UUID			NOT NULL,
	data_matricula	DATE			NOT NULL DEFAULT CURRENT_DATE,
	PRIMARY KEY (aluno_id, turma_id),
	FOREIGN KEY (aluno_id) REFERENCES aluno(id),
	FOREIGN KEY (turma_id) REFERENCES turma(id)
);