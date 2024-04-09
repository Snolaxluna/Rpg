CREATE TABLE players (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) DEFAULT NULL,
    dado INT NOT NULL CHECK (dado BETWEEN 1 AND 20),
    PRIMARY KEY (id)
);