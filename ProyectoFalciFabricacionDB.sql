CREATE DATABASE proyecto_falci_fabricaciones;

USE proyecto_falci_fabricaciones;

CREATE TABLE administradores(
	id int not null auto_increment primary key,
    usuario VARCHAR(100),
    clave VARCHAR(100)
);

SELECT * FROM administradores;
DESCRIBE administradores;

CREATE TABLE empleados(
	id int not null auto_increment primary key,
    documento int,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    domicilio VARCHAR(100),
    telefono VARCHAR(100)
);

SELECT * FROM empleados;
DESCRIBE empleados;

CREATE TABLE liquidacion(
	id int not null auto_increment primary key,
    documento int,
    apellido VARCHAR(100),
    nombre VARCHAR(100),
    semanal int
);

SELECT * FROM liquidacion;
DESCRIBE liquidacion;

CREATE TABLE prestamos(
	id int not null auto_increment primary key,
    documento int,
    apellido VARCHAR(100),
    nombre VARCHAR(100),
    monto int
);

SELECT * FROM prestamos;
DESCRIBE prestamos;

CREATE TABLE presupuestos(
	id int not null auto_increment primary key,
    nombre VARCHAR(100),
    trabajo VARCHAR(100),
    material int,
    manoDeObra int,
    ganancia float,
    total float
);

SELECT * FROM presupuestos;
DESCRIBE presupuestos;

CREATE TABLE stock(
	id int not null auto_increment primary key,
    codigo VARCHAR(100),
    tipo VARCHAR(100),
    espesor VARCHAR(100),
    material VARCHAR(100),
    medida int,
    cantidad int
);

SELECT * FROM stock;
DESCRIBE stock;