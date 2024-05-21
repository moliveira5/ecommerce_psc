CREATE DATABASE loja_esportes;
USE loja_esportes;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    modelo VARCHAR(100),
    categoria VARCHAR(100),
    marca VARCHAR(100),
    preco DOUBLE,
    tamanhoNumerico INT,
    tamanho CHAR(1)
);
