-- V2: Migrations para adicionar a coluna de rank n coluna cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);