CREATE DATABASE minimarket;

USE minimarket;

CREATE TABLE Clientes( 
    id INT(20) AUTO_INCREMENT ,
    Nombre VARCHAR(50) ,
    Rut VARCHAR(50) ,
    Nacionalidad VARCHAR(50) ,
    preferencial BIT DEFAULT 0,

    PRIMARY KEY(id));

CREATE TABLE Categoria (
    id INT(20) AUTO_INCREMENT ,
    Nombre VARCHAR(50) ,
    PRIMARY KEY(id));

CREATE TABLE producto (
    id INT(20) AUTO_INCREMENT,
    nombre VARCHAR(50),
    Categoria_id_fk INT,
    precio INT,
    PRIMARY KEY (id),
    FOREIGN KEY (Categoria_id_fk) REFERENCES Categoria(id));

CREATE TABLE factura (
    id INT AUTO_INCREMENT,
    cliente_id_fk INT,
    fecha DATETIME,
    pagado BIT DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id_fk) REFERENCES cliente(id)
);

CREATE TABLE detalle(
    id INT AUTO_INCREMENT,
    factura_id_fk INT,
    producto_id_fk INT,
    cantidad INT,
    precio INT,

    PRIMARY KEY (id),
    FOREIGN KEY (factura_id_fk) REFERENCES factura(id),
    FOREIGN KEY (producto_id_fk) REFERENCES producto(id)

CREATE TABLE Historial_de_precios (
    id INT(30) AUTO_INCREMENT ,
     Nombre VARCHAR(30) ,
     PRIMARY KEY(id));

