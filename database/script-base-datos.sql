-- =========================================================
-- Base de datos del módulo de Inventario - Taller Lizardo Car
-- GA7-220501096-AA3-EV01 (reutiliza la BD de la evidencia EV01)
-- =========================================================

CREATE DATABASE IF NOT EXISTS taller_lizardo_car;
USE taller_lizardo_car;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(60) NOT NULL,
    marca VARCHAR(60) NOT NULL,
    cantidad INT NOT NULL DEFAULT 0,
    precio DOUBLE NOT NULL DEFAULT 0
);

-- Datos de ejemplo (opcional, para probar las consultas)
INSERT INTO productos (nombre, categoria, marca, cantidad, precio) VALUES
('Bujías', 'Encendido', 'NGK', 17, 12000),
('Refrigerante', 'Refrigeración', 'Prestone', 23, 25000),
('Pastillas de freno', 'Frenos', 'Brembo', 10, 150000);

-- Usuario de aplicación recomendado para la conexión JDBC
-- (ejecutar solo si el usuario no existe todavía)
-- CREATE USER 'taller_app'@'localhost' IDENTIFIED BY 'TallerLizardo2026*';
-- GRANT ALL PRIVILEGES ON taller_lizardo_car.* TO 'taller_app'@'localhost';
-- FLUSH PRIVILEGES;
