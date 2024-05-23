DROP DATABASE IF EXISTS LaRedonda;
CREATE DATABASE LaRedonda;
USE LaRedonda;

CREATE TABLE usuario (
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50),
    contraseña_usuario VARCHAR(50),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono INT,
    correo VARCHAR(50)
);

CREATE TABLE producto (
	id_producto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    liga VARCHAR(30),
    precio INT(30)
);

CREATE TABLE carrito (
   id_carrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   id_usuario INT NOT NULL,
   id_producto INT NOT NULL,
   FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
   FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE formaPago (
	id_formaPago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    metodo VARCHAR(50), -- PayPal, Tarjeta, Criptomonedas
    saldo INT,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

INSERT INTO producto (nombre, liga, precio) VALUES
('Real Madrid', 'LaLiga', 120),
('FC Barcelona', 'LaLiga', 115),
('Atlético de Madrid', 'LaLiga', 80),
('Sevilla FC', 'LaLiga', 95),
('Real Betis', 'LaLiga', 95),

('Manchester United', 'Premier League', 95),
('Manchester City', 'Premier League', 85),
('Arsenal', 'Premier League', 90),
('Liverpool', 'Premier League', 80),
('Aston Villa', 'Premier League', 70),

('AC Milan', 'Serie A', 100),
('Inter de Milan', 'Serie A', 90),
('Juventus', 'Serie A', 110),
('AS Roma', 'Serie A', 80),
('Fiorentina', 'Serie A', 95),

('FC Bayern', 'Bundesliga', 95),
('Borussia Dortmund', 'Bundesliga', 85),
('Bayer Leverkusen', 'Bundesliga', 75),
('RB Leipzig', 'Bundesliga', 70),
('E. Frankfurt', 'Bundesliga', 65),

('OL. Lyon', 'Ligue1', 95),
('AS Monaco', 'Ligue1', 80),
('PSG', 'Ligue1', 120),
('OL. Marsella', 'Ligue1', 70),
('Rennes', 'Ligue1', 60);