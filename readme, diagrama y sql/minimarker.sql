CREATE DATABASE minimarket;

USE minimarket;

CREATE TABLE clientes( 
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    rut VARCHAR(50),
    preferencial TINYINT,

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
    clientes_id_fk INT,
    fecha DATETIME,
    pagado TINYINT,

    PRIMARY KEY (id),
    FOREIGN KEY (clientes_id_fk) REFERENCES clientes(id)
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
     
CREATE TABLE valor_total (
    id INT AUTO_INCREMENT,
    totalprecios INT,
    factura_id_fk INT,

    PRIMARY KEY (id)
);




DELIMITER //
CREATE TRIGGER trigger_historial_producto_valor BEFORE UPDATE ON producto
    FOR EACH ROW
BEGIN
	INSERT INTO historial_de_precios VALUES(NULL,OLD.id,OLD.precio,NOW());
END //
DELIMITER ;   
						
						
DELIMITER //
CREATE TRIGGER iva_producto AFTER INSERT ON producto
FOR EACH ROW
BEGIN
UPDATE producto SET NEW.precio = NEW.precio*1.21 WHERE id = NEW.id;
END //
DELIMITER ;



DELIMITER //
CREATE PROCEDURE descuento1(_valorTotal INT, _idfactura INT)
BEGIN
IF _valortotal >=50000 THEN 
   SET _valorTotal = _valorTotal * 0.80;
   INSERT INTO valor_total VALUES (NULL, _valorTotal, _idfactura);
ELSE 
   SET _valorTotal =  _valorTotal * 0.95;
   INSERT INTO valor_total VALUES (NULL, _valorTotal, _idfactura);
END IF;

END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE pagado1(_idfactura INT)
BEGIN
DECLARE cantidad_id_encontrados INT;

SET cantidad_id_encontrados = (SELECT COUNT(id) FROM valor_total WHERE factura_id_fk = _idfactura);

    IF cantidad_id_encontrados = 1 THEN
        UPDATE factura SET pagado = 1 WHERE id = _idfactura;
    ELSE
        UPDATE factura SET pagado = 0 WHERE id = _idfactura;

    END IF;

END//
DELIMITER ;
						
DELIMITER //
CREATE FUNCTION devolucion_iva(_total INT) RETURNS INT
BEGIN
DECLARE nuevototal INT;

SET nuevototal = _total * 1.21;

   RETURN nuevototal;
END//
DELIMITER ;
