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
     Nombre VARCHAR(30),

     PRIMARY KEY(id)
     );
     
SET @tecnologia_id= (SELECT id FROM categoria WHERE nombre = 'tecnologia');
SET @aseo_id= (SELECT id FROM categoria WHERE nombre = 'productos de aseo');
SET @comida_id= (SELECT id FROM categoria WHERE nombre = 'comida');

INSERT INTO producto (nombre,categoria_id_fk,precio) 
VALUES ('caja de gansito',@comida_id,5000),
('caja de chocolito',@comida_id,4000),
('caja de chamito',@comida_id,2000),
('paquete de esponjas',@aseo_id,750),
('escoba para trapear',@aseo_id,1500),
('cloro',@aseo_id,2000),
('tablet samsung',@tecnologia_id,50000),
('celular nokia',@tecnologia_id,100000),
('notebook hp',@tecnologia_id,500000);


     

