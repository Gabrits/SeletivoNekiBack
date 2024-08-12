CREATE TABLE Skills (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    imagem_url VARCHAR(255)
);

CREATE TABLE Usuarios (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE Usuarios_Skills (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES Usuarios(id) ON DELETE CASCADE,
    skill_id INTEGER REFERENCES Skills(id) ON DELETE CASCADE,
    level VARCHAR(50),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES Skills(id)
);
