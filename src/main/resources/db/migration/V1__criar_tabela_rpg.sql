CREATE TABLE players (
id bigint(20) NOT NULL AUTO_INCREMENT,
nome varchar(100) DEFAULT NULL,
dado INT NOT NULL CHECK (dado >= 1 AND <= 20)
PRIMARY KEY (id)
);