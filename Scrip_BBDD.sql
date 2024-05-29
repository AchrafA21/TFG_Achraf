CREATE TABLE IF NOT EXISTS trabajadores (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    fecha_nac DATE NOT NULL
);



select * from alquiler_clientes;
drop TABLE  alquiler_clientes;

CREATE TABLE IF NOT EXISTS alquiler_clientes (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255)  NULL,
    correo VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NULL,
    fecha_nac DATE NOT NULL,
    direccion VARCHAR(255)  NULL,
    telefono VARCHAR(255)  NULL,
    ciudad VARCHAR(255)  NULL,
    edad VARCHAR(255)  NULL,
    sexo VARCHAR(255)  NULL,
);




CREATE TABLE IF NOT EXISTS vehiculos (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    año_fabricación INT NOT NULL,
    capacidad INT  NOT NULL,
    conbustible VARCHAR(255) NOT NULL,
    transmision VARCHAR(255) NOT NULL,
    precio_dia INT  NOT NULL,
    precio_mes INT  NOT NULL,
    id_modelo   INT NOT NULL, 
  
);

CREATE TABLE IF NOT EXISTS modelo (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_creacion DATE  NULL,
    id_vehiculo int NOT NULL ,
   
); 

CREATE TABLE IF NOT EXISTS reserva (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_vehiculo INT NOT NULL,
    id_modelo   INT NOT NULL, 
    fecha_recogida INT NOT NULL,
    fecha_devolucion INT NOT NULL
);


-- Ejemplo de inserción de datos de prueba
INSERT INTO trabajadores (nombre, correo, contraseña, fecha_nac) 
VALUES
    ('Juan Pérez', 'juan@gmail.com', 'clave123', '1990-05-15'),
    ('María López', 'maria@gmail.com', 'segura456', '1988-12-10'),
    ('Carlos Ramírez', 'carlos@gmail.com', 'secreta789', '1995-07-22');

INSERT INTO alquiler_clientes (nombre, apellido, correo, contraseña, fecha_nac, direccion, telefono, ciudad, edad, sexo ) 
VALUES  ('Marcos', 'Gonzalez', 'MarcosGzl@gmail.com', 'j2992akskmnza:;@', '1990-05-15', 'C/ Velazquez', '634783784', 'Madrid', '24', 'Hombre');

INSERT INTO alquiler_clientes (nombre, apellido, correo, contraseña, fecha_nac, direccion, telefono, ciudad, edad, sexo ) 
VALUES  ('Raul', 'Martinez', 'raulmartinz@gmail.com', 'jdkdjjsw-sdwn37478q', '1995-06-19', 'C/ Alcala', '684898497', 'Madrid', '23', 'Hombre');

INSERT INTO alquiler_clientes (nombre, apellido, correo, contraseña, fecha_nac, direccion, telefono, ciudad, edad, sexo) 
VALUES ('Ana', 'Martinez', 'AnaMart@gmail.com', 'Pass@1234', '1985-03-22', 'Av. Reina Sofia', '612345678', 'Barcelona', '39', 'Mujer')

, ('Luis', 'Fernandez', 'LuisFndz@hotmail.com', 'qFwerty@78', '1978-11-02', 'C/ Gran Via', '698765432', 'Valencia', '45', 'Hombre')

, ('Marta', 'Lopez', 'MartaLopez@yahoo.com', 'martXa#2021', '1992-07-11', 'Paseo de Gracia', '622334455', 'Sevilla', '31', 'Mujer')

, ('Carlos', 'Sanchez', 'CarlosS@gmail.com', 'abcDe12345', '1989-09-09', 'C/ Serrano', '655443322', 'Bilbao', '34', 'Hombre')

,('Laura', 'Gomez', 'LauraG@gmail.com', 'Laura34*pass', '1995-02-28', 'C/ Princesa', '677889900', 'Zaragoza', '29', 'Mujer')

, ('Jose', 'Garcia', 'JoseG@gmail.com', 'Secure@12J3', '1980-12-12', 'C/ Mayor', '612223344', 'Malaga', '43', 'Hombre')

, ('Elena', 'Moreno', 'ElenaM@gmail.com', 'eleNa#pass12', '1993-10-25', 'Av. Libertad', '611998877', 'Murcia', '30', 'Mujer')

, ('David', 'Ruiz', 'DavidR@gmail.com', 'daviD@123', '1984-06-16', 'C/ Alcala', '677556644', 'Alicante', '40', 'Hombre')

, ('Isabel', 'Ramirez', 'IsabelR@gmail.com', 'isaB*2022*', '1991-08-30', 'C/ Sol', '688332211', 'Granada', '32', 'Mujer')

, ('Juan', 'Herrera', 'JuanH@gmail.com', 'juan*Secu9re9', '1988-04-04', 'C/ Luna', '699887766', 'Toledo', '36', 'Hombre')

, ('Patricia', 'Diaz', 'PatriciaD@gmail.com', 'paPtdiaz123@', '1996-11-19', 'C/ Estrella', '677554433', 'Valladolid', '27', 'Mujer')

, ('Raul', 'Ortega', 'RaulO@gmail.com', 'raul20M21*', '1983-01-15', 'C/ Jardines', '699223344', 'Santander', '41', 'Hombre')

, ('Sofia', 'Blanco', 'SofiaB@gmail.com', 'sofia@passz23', '1994-03-05', 'C/ Flores', '677998877', 'Salamanca', '30', 'Mujer')

, ('Pablo', 'Martinez', 'PabloM@gmail.com', 'Qablo@2020', '1977-05-27', 'Av. Maritima', '688776655', 'Las Palmas', '46', 'Hombre')

,('Lucia', 'Perez', 'LuciaP@gmail.com', 'Lucia*2023', '1997-09-13', 'C/ Luna', '611443322', 'Oviedo', '26', 'Mujer')

, ('Miguel', 'Lopez', 'MiguelL@gmail.com', 'migueZl@pass', '1982-07-07', 'C/ Ronda', '699334455', 'Huelva', '41', 'Hombre')

,('Cristina', 'Santos', 'CristinaS@gmail.com', 'cris*pa1Xss', '1998-12-21', 'C/ Sierra', '688554433', 'Almeria', '25', 'Mujer')

,('Antonio', 'Reyes', 'AntonioR@gmail.com', 'antonioJ@2021', '1975-11-03', 'C/ Campo', '677665544', 'Cadiz', '48', 'Hombre')

, ('Carmen', 'Nunez', 'CarmenN@gmail.com', 'carKmen@pass0', '1999-06-09', 'C/ Mar', '688443322', 'Badajoz', '24', 'Mujer');
----------------------------------------------------------------
INSERT INTO Modelo (nombre, fecha_creacion, id_vehiculo)
VALUES 
('Golf Mk1', '1974-05-29', 1),
('Golf Mk2', '1983-09-05', 1),
('Golf Mk3', '1991-08-01', 1),
('Golf Mk4', '1997-09-12', 1),
('Golf Mk5', '2003-10-19', 1),
('Golf Mk6', '2008-10-06', 1),
('Golf Mk7', '2012-11-04', 1),
('Golf Mk8', '2019-10-24', 1),
('Golf GTI Mk1', '1976-06-14', 1),
('Golf GTI Mk2', '1984-09-01', 1),
('Golf GTI Mk3', '1991-11-08', 1),
('Golf GTI Mk4', '1998-10-08', 1),
('Golf GTI Mk5', '2004-03-25', 1),
('Golf GTI Mk6', '2009-04-01', 1),
('Golf GTI Mk7', '2013-05-10', 1),
('Golf GTI Mk8', '2020-02-27', 1),
('Golf R Mk4', '2002-05-01', 1),
('Golf R Mk5', '2007-09-12', 1),
('Golf R Mk6', '2010-07-15', 1),
('Golf R Mk7', '2014-08-27', 1)
('GTD', '2023-06-20', 1);

INSERT INTO Modelo (nombre, fecha_creacion, id_vehiculo)
VALUES 
('X1', '2024-03-02', 3),
('X3', '2023-05-15', 3),
('X5', '2022-08-10', 3),
('X6', '2021-07-20', 3),
('X7', '2020-12-25', 3),
('Series 1', '2019-11-18', 3),
('Series 2', '2018-04-05', 3),
('Series 3', '2017-06-09', 3),
('Series 4', '2016-09-30', 3),
('Series 5', '2015-01-14', 3),
('Series 6', '2014-02-22', 3),
('Series 7', '2013-03-17', 3),
('Series 8', '2012-05-24', 3),
('i3', '2021-07-13', 3),
('i4', '2020-10-09', 3),
('i8', '2019-12-01', 3),
('Z4', '2018-11-25', 3),
('M2', '2017-08-16', 3),
('M3', '2016-06-30', 3),
('M4', '2015-04-07', 3);
-----------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Modelo (nombre, fecha_creacion, id_vehiculo)
VALUES
('Cerato', '2024-05-14', 0),
('Rio', '2023-01-15', 0),
('Soul', '2022-02-20', 0),
('Forte', '2021-03-25', 0),
('Optima', '2020-04-30', 0),
('Stinger', '2019-05-10', 0),
('Seltos', '2018-06-15', 0),
('Sportage', '2017-07-20', 0),
('Sorento', '2016-08-25', 0),
('Telluride', '2015-09-05', 0),
('Cadenza', '2014-10-10', 0),
('K5', '2013-11-15', 0),
('Niro', '2012-12-20', 0),
('Stonic', '2011-01-25', 0),
('Picanto', '2010-02-10', 0),
('Carnival', '2009-03-15', 0),
('Cerato', '2008-04-20', 0),
('Ceed', '2007-05-25', 0),
('Carens', '2006-06-30', 0),
('XCeed', '2005-07-15', 0),
('ProCeed', '2004-08-20', 0);
--------------------------------------
INSERT INTO Modelo (nombre, fecha_creacion, id_vehiculo)
VALUES 
('Model S', '2012-06-22', 2),
('Model X', '2015-09-29', 2),
('Model 3', '2017-07-07', 2),
('Model Y', '2020-03-13', 2),
('Roadster', '2008-02-01', 2),
('Cybertruck', '2021-12-01', 2),
('Model S Plaid', '2021-06-10', 2),
('Model X Plaid', '2022-01-01', 2),
('Model 3 Standard Range Plus', '2019-02-28', 2),
('Model 3 Long Range', '2018-06-01', 2),
('Model 3 Performance', '2018-07-01', 2),
('Model Y Long Range', '2020-03-14', 2),
('Model Y Performance', '2020-06-15', 2),
('Model S Long Range', '2021-01-29', 2),
('Model X Long Range', '2021-02-01', 2),
('Semi', '2022-12-01', 2),
('Model 3 Rear-Wheel Drive', '2022-01-01', 2),
('Model Y Rear-Wheel Drive', '2022-03-01', 2),
('Model S Dual Motor', '2015-04-08', 2),
('Model X Dual Motor', '2016-09-01', 2);
------------------------------------------

INSERT INTO Modelo (nombre, fecha_creacion, id_vehiculo)
VALUES 
('A1', '2010-05-29', 4),
('A3', '1996-09-15', 4),
('A4', '1994-11-25', 4),
('A5', '2007-06-30', 4),
('A6', '1994-10-06', 4),
('A7', '2010-07-24', 4),
('A8', '1994-11-11', 4),
('Q2', '2016-09-01', 4),
('Q3', '2011-06-20', 4),
('Q5', '2008-08-15', 4),
('Q7', '2005-03-10', 4),
('Q8', '2018-11-20', 4),
('TT', '1998-09-20', 4),
('R8', '2007-03-28', 4),
('RS3', '2011-05-12', 4),
('RS4', '2000-09-05', 4),
('RS5', '2010-12-18', 4),
('RS6', '2002-07-22', 4),
('RS7', '2013-06-30', 4),
('RS Q3', '2012-04-01', 4);


INSERT INTO vehiculos (nombre, año_fabricación, capacidad, conbustible, transmision, precio_dia, precio_mes, id_modelo) 
VALUES ('Kia', 2022, 5, 'Gasolina', 'Manual', 50, 100, 0);
INSERT INTO vehiculos (nombre, año_fabricación, capacidad, combustible, transmision, precio_dia, precio_mes, id_modelo) 
VALUES 
('BMW', 2023, 5, 'Gasolina', 'Automático', 80, 150, 4),
('BMW', 2022, 5, 'Gasolina', 'Automático', 90, 160, 5),
('BMW', 2021, 5, 'Gasolina', 'Automático', 100, 170, 6),
('BMW', 2020, 5, 'Gasolina', 'Automático', 110, 180, 7),
('BMW', 2019, 5, 'Gasolina', 'Automático', 60, 120, 8),
('BMW', 2018, 5, 'Gasolina', 'Automático', 65, 125, 9),
('BMW', 2017, 5, 'Gasolina', 'Automático', 70, 130, 10),
('BMW', 2016, 5, 'Gasolina', 'Automático', 75, 135, 11),
('BMW', 2015, 5, 'Gasolina', 'Automático', 80, 140, 12),
('BMW', 2014, 5, 'Gasolina', 'Automático', 85, 145, 13),
('BMW', 2013, 5, 'Gasolina', 'Automático', 90, 150, 14),
('BMW', 2012, 5, 'Gasolina', 'Automático', 95, 155, 15),
('BMW', 2021, 5, 'Eléctrico', 'Automático', 70, 140, 16),
('BMW', 2020, 5, 'Eléctrico', 'Automático', 75, 145, 17),
('BMW', 2019, 5, 'Híbrido', 'Automático', 80, 150, 18),
('BMW', 2018, 2, 'Gasolina', 'Automático', 85, 155, 19),
('BMW', 2017, 2, 'Gasolina', 'Automático', 90, 160, 20),
('BMW', 2016, 2, 'Gasolina', 'Automático', 95, 165, 21),
('BMW', 2015, 2, 'Gasolina', 'Automático', 100, 170, 22),
('Kia', 2023, 5, 'Gasolina', 'Manual', 45, 90, 23),
('Kia', 2022, 5, 'Gasolina', 'Manual', 50, 95, 24),
('Kia', 2021, 5, 'Gasolina', 'Manual', 55, 100, 25),
('Kia', 2020, 5, 'Gasolina', 'Automático', 60, 105, 26),
('Kia', 2019, 5, 'Gasolina', 'Automático', 65, 110, 27),
('Kia', 2018, 5, 'Gasolina', 'Automático', 70, 115, 28),
('Kia', 2017, 5, 'Gasolina', 'Automático', 75, 120, 29),
('Kia', 2016, 5, 'Gasolina', 'Automático', 80, 125, 30),
('Kia', 2015, 5, 'Gasolina', 'Automático', 85, 130, 31),
('Kia', 2014, 5, 'Gasolina', 'Automático', 90, 135, 32),
('Kia', 2013, 5, 'Gasolina', 'Automático', 95, 140, 33),
('Kia', 2012, 5, 'Híbrido', 'Automático', 100, 145, 34),
('Kia', 2011, 5, 'Gasolina', 'Automático', 105, 150, 35),
('Kia', 2010, 4, 'Gasolina', 'Manual', 55, 100, 36),
('Kia', 2009, 7, 'Gasolina', 'Automático', 80, 140, 37),
('Kia', 2008, 5, 'Gasolina', 'Manual', 60, 110, 38),
('Kia', 2007, 5, 'Gasolina', 'Manual', 65, 115, 39),
('Kia', 2006, 5, 'Gasolina', 'Manual', 70, 120, 40),
('Kia', 2005, 5, 'Gasolina', 'Manual', 75, 125, 41),
('Kia', 2004, 5, 'Gasolina', 'Manual', 80, 130, 42)
('Volkswagen Golf Mk1', 1974, 5, 'Gasolina', 'Manual', 40, 80, 43),
('Volkswagen Golf Mk2', 1983, 5, 'Gasolina', 'Manual', 45, 85, 44),
('Volkswagen Golf Mk3', 1991, 5, 'Gasolina', 'Manual', 50, 90, 45),
('Volkswagen Golf Mk4', 1997, 5, 'Gasolina', 'Manual', 55, 95, 46),
('Volkswagen Golf Mk5', 2003, 5, 'Gasolina', 'Manual', 60, 100, 47),
('Volkswagen Golf Mk6', 2008, 5, 'Gasolina', 'Manual', 65, 105, 48),
('Volkswagen Golf Mk7', 2012, 5, 'Gasolina', 'Manual', 70, 110, 49),
('Volkswagen Golf Mk8', 2019, 5, 'Gasolina', 'Manual', 75, 115, 50),
('Volkswagen Golf GTI Mk1', 1976, 5, 'Gasolina', 'Manual', 80, 120, 51),
('Volkswagen Golf GTI Mk2', 1984, 5, 'Gasolina', 'Manual', 'Manual',40,80,52);
('Tesla', 2012, 5, 'Eléctrico', 'Automático', 100, 300, 63),
('Tesla', 2015, 7, 'Eléctrico', 'Automático', 120, 360, 64),
('Tesla', 2017, 5, 'Eléctrico', 'Automático', 80, 240, 65),
('Tesla', 2020, 5, 'Eléctrico', 'Automático', 90, 270, 66),
('Tesla', 2008, 2, 'Eléctrico', 'Manual', 110, 330, 67),
('Tesla', 2021, 5, 'Eléctrico', 'Automático', 150, 450, 68),
('Tesla', 2021, 5, 'Eléctrico', 'Automático', 130, 390, 69),
('Tesla', 2022, 7, 'Eléctrico', 'Automático', 140, 420, 70),
('Tesla', 2019, 5, 'Eléctrico', 'Automático', 85, 255, 71),
('Tesla', 2018, 5, 'Eléctrico', 'Automático', 90, 270, 72),
('Tesla', 2018, 5, 'Eléctrico', 'Automático', 95, 285, 73),
('Tesla', 2020, 5, 'Eléctrico', 'Automático', 100, 300, 74),
('Tesla', 2020, 5, 'Eléctrico', 'Automático', 110, 330, 75),
('Tesla', 2021, 5, 'Eléctrico', 'Automático', 120, 360, 76),
('Tesla', 2021, 7, 'Eléctrico', 'Automático', 130, 390, 77),
('Tesla', 2022, 2, 'Eléctrico', 'Automático', 140, 420, 78),
('Tesla', 2022, 5, 'Eléctrico', 'Automático', 90, 270, 79),
('Tesla', 2022, 5, 'Eléctrico', 'Automático', 95, 285, 80),
('Tesla', 2015, 5, 'Eléctrico', 'Automático', 100, 300, 81),
('Tesla', 2016, 7, 'Eléctrico', 'Automático', 110, 330, 82),
('Audi', 1996, 5, 'Gasolina', 'Manual', 60, 180, 84),
('Audi', 1994, 5, 'Gasolina', 'Manual', 65, 195, 85),
('Audi', 2007, 5, 'Gasolina', 'Manual', 70, 210, 86),
('Audi', 1994, 5, 'Gasolina', 'Manual', 75, 225, 87),
('Audi', 2010, 5, 'Gasolina', 'Manual', 80, 240, 88),
('Audi', 1994, 5, 'Gasolina', 'Manual', 85, 255, 89),
('Audi', 2016, 5, 'Gasolina', 'Automático', 90, 270, 90),
('Audi', 2011, 5, 'Gasolina', 'Automático', 95, 285, 91),
('Audi', 2008, 5, 'Gasolina', 'Automático', 100, 300, 92),
('Audi', 2005, 5, 'Gasolina', 'Automático', 105, 315, 93),
('Audi', 2018, 5, 'Gasolina', 'Automático', 110, 330, 94),
('Audi', 1998, 2, 'Gasolina', 'Manual', 115, 345, 95),
('Audi', 2007, 2, 'Gasolina', 'Manual', 120, 360, 96),
('Audi', 2011, 5, 'Gasolina', 'Automático', 125, 375, 97),
('Audi', 2000, 5, 'Gasolina', 'Automático', 130, 390, 98),
('Audi', 2010, 5, 'Gasolina', 'Automático', 135, 405, 99);


-- Verificación de los datos insertados
SELECT * FROM trabajadores;
delete  from trabajadores;
DELETE FROM trabajadores WHERE nombre='nbk';