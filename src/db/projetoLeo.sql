/* Lógico_1: */

DROP DATABASE IF EXISTS projetoLeo;

CREATE DATABASE IF NOT EXISTS projetoLeo;

USE projetoLeo;

CREATE TABLE IF NOT EXISTS Usuario (
    id_usuario int PRIMARY KEY AUTO_INCREMENT,
    email varchar(45) not null,
    senha varchar(45) not null,
    nome varchar(45) not null,
    idade int not null,
    quiz_completo int default 0,
    created_at datetime default CURRENT_TIMESTAMP()
);

CREATE TABLE IF NOT EXISTS Quiz (
    quiz_categoria varchar(45) not null,
    quiz_nome varchar(45) not null,
    quiz_desc varchar(255) not null,
    quiz_dica varchar(45),
    quiz_tag varchar(45),
    quiz_data json not null,
    respondidos int not null default 0,
    quiz_id varchar(36),
    fk_Usuario_id_usuario int,
    PRIMARY KEY (quiz_id),

    CHECK (quiz_categoria IN ('Geografia', 'Matemática', 'Português', 'História', 'Música', 'Ciências', 'Esportes'))
);
 
ALTER TABLE Quiz ADD CONSTRAINT FK_Quiz_2
    FOREIGN KEY (fk_Usuario_id_usuario)
    REFERENCES Usuario (id_usuario)
    ON DELETE CASCADE;