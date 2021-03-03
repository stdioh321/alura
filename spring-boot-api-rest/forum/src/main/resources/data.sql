INSERT INTO USUARIO(nome, email, senha, created_at, updated_at)
VALUES ('Peach', 'aluno@gmail.com', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO USUARIO(nome, email, senha, created_at, updated_at)
VALUES ('Mario', 'mario@gmail.com', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO CURSO(nome, categoria)
VALUES ('Spring Boot', 'Programacao');
INSERT INTO CURSO(nome, categoria)
VALUES ('HTML 5', 'Front-End');
INSERT INTO CURSO(nome, categoria)
VALUES ('Javascript', 'Front-End');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES ('Duvida 5', 'Tudo Errado ao criar projeto 1', '2021-03-01 01:01:01', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES ('Duvida 1', 'Erro ao criar projeto 2', '2021-03-01 01:02:01', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES ('Duvida 4', 'Assim nao da', '2021-03-01 01:03:01', 'NAO_RESPONDIDO', 2, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES ('Duvida 3', 'Erro ao criar projeto 4', '2021-03-01 01:04:01', 'NAO_RESPONDIDO', 2, 2);

INSERT INTO RESPOSTA(mensagem, topico_id, data_criacao, autor_id, solucao)
VALUES ('Muito estranho', 3, '2021-03-01 01:08:01', 1, false);


/*
COMMIT;
*/

