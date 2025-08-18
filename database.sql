DROP DATABASE IF EXISTS neostore_db;

CREATE DATABASE neostore_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE neostore_db;

CREATE TABLE fornecedores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    description TEXT,
    cnpj VARCHAR(18) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_email (email),
    UNIQUE KEY uk_cnpj (cnpj)
);

INSERT INTO fornecedores (name, email, description, cnpj) VALUES
('Verificado Alfa', 'alfa@verificado.com', 'Primeiro fornecedor com CNPJ válido.', '53.464.706/0001-70'),
('Verificado Beta', 'beta@verificado.com', 'Segundo fornecedor com CNPJ válido.', '32.393.455/0001-00'),
('Verificado Gama', 'gama@verificado.com', 'Terceiro fornecedor com CNPJ válido.', '50.358.313/0001-94'),
('TecnoInfo Componentes', 'vendas@tecnoinfo.com.br', 'Fornecedor de peças de computador e periféricos.', '50.358.313/0001-94'),
('Malhas & Fios do Sul', 'contato@malhasdosul.com', 'Distribuidora de tecidos e malhas para confecção.', '63.071.237/0001-83'),
('Café Gourmet Grão de Ouro', 'comercial@graodeouro.net', 'Produtor e distribuidor de cafés especiais.', '93.570.046/0001-27'),
('Agropecuária Campo Verde', 'adm@campoverdeagro.com', 'Insumos agrícolas e ferramentas para o campo.', '14.000.520/0001-09');