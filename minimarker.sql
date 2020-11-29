CREATE DATABASE minimarket;

USE minimarket;

CREATE TABLE clientes( 
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    rut VARCHAR(50),
    preferencial BIT DEFAULT 0,

    PRIMARY KEY(id)
    );

CREATE TABLE categoria (
    id INT AUTO_INCREMENT,
    Nombre VARCHAR(50),
   
    PRIMARY KEY(id)
    );

CREATE TABLE producto (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    categoria_id_fk INT,
    precio INT,

    PRIMARY KEY (id),
    FOREIGN KEY (categoria_id_fk) REFERENCES categoria(id)
    );

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
    );

CREATE TABLE historial_de_precios (
     id INT AUTO_INCREMENT,
     producto_id_fk INT,
     precio INT,
     fechadecambio DATETIME,

     PRIMARY KEY (id),
     FOREIGN KEY (producto_id_fk) REFERENCES producto(id)
     );




DELIMITER //
CREATE TRIGGER trigger_historial_producto_valor BEFORE UPDATE ON producto
    FOR EACH ROW
BEGIN
	INSERT INTO historial_de_precios VALUES(NULL,OLD.id,OLD.precio,NOW());
END //
DELIMITER ;   


DELIMITER //
CREATE TRIGGER 

