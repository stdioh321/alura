INSERT INTO USUARIO(nome, email, senha, created_at, updated_at)
VALUES ('Aluno', 'aluno@gmail.com', '$2a$10$c1QJja9/ZSXWrjCKNDe4EeLjvCRTGIRtvxDd9PC1nXC9.n59YP.JC', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO USUARIO(nome, email, senha, created_at, updated_at)
VALUES ('Moderador', 'moderador@gmail.com', '$2a$10$c1QJja9/ZSXWrjCKNDe4EeLjvCRTGIRtvxDd9PC1nXC9.n59YP.JC', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO PERFIL(id,name)
VALUES (1, 'ROLE_ALUNO');

INSERT INTO PERFIL(id,name)
VALUES (2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id,perfis_id)
VALUES (1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id,perfis_id)
VALUES (2, 2);


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

