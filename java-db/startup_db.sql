-- CREATE DATABASE IF NOT EXISTS db;
--
-- USE db;

DROP TABLE IF EXISTS  produto;
CREATE TABLE IF NOT EXISTS produto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS produto(
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
    );



INSERT INTO
    produto(nome,descricao)
VALUES
('Caneta', 'Preta');
INSERT INTO
    produto(nome,descricao)
VALUES
('Borracha', 'Vermelha e Azul');
INSERT INTO
        produto(nome,descricao)
    VALUES
        ('Caneta', 'Preta');
INSERT INTO
        produto(nome,descricao)
    VALUES
        ('Borracha', 'Vermelha e Azul');