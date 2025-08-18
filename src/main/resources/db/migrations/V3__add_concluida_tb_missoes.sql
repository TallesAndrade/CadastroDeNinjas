-- V3: Migrations para adicionar a coluna de concluida na coluna missoes
ALTER TABLE tb_missoes
ADD COLUMN concluida BOOLEAN  DEFAULT FALSE;
