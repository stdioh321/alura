-- CREATE DATABASE IF NOT EXISTS db;
--
-- USE db;

DROP TABLE IF EXISTS  produto;

DROP TABLE IF EXISTS  categoria;

CREATE TABLE IF NOT EXISTS categoria(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS produto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);


INSERT INTO categoria(nome) VALUES('Eletronicos');

INSERT INTO categoria(nome) VALUES('Eletrodomesticos');

INSERT INTO categoria(nome) VALUES('Moveis');

INSERT INTO
    produto(nome,descricao,categoria_id)
VALUES
('Celular', 'LG', 1);

INSERT INTO
    produto(nome,descricao,categoria_id)
VALUES
('TV', '50 Polegadas', 1)



INSERT INTO
    produto(nome,descricao,categoria_id)
VALUES
('Sofa', 'Marrom', 3);
