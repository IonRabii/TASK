-- create country table
DROP TABLE IF EXISTS Country CASCADE;

CREATE TABLE Country
(
    ID   SMALLINT,
    NAME VARCHAR(25) NOT NULL UNIQUE,
    CODE VARCHAR(3)  NOT NULL UNIQUE,
    PRIMARY KEY (ID)
);

-- create brand table
DROP TABLE IF EXISTS Brand CASCADE;

CREATE TABLE Brand
(
    ID         INT,
    NAME       VARCHAR(20) NOT NULL UNIQUE,
    COUNTRY_ID SMALLINT,
    PRIMARY KEY (ID),
    FOREIGN KEY (COUNTRY_ID) REFERENCES Country (ID)
);

-- create brand table
DROP TABLE IF EXISTS Car CASCADE;

CREATE TABLE Car
(
    ID               INT,
    NAME             VARCHAR(15) NOT NULL,
    BRAND_ID         INT,
    COLOR            VARCHAR(10),
    MANUFACTORY_DATE DATE,
    PRICE            DECIMAL(8, 2),
    CARCASE_TYPE     VARCHAR(15),
    PRIMARY KEY (ID),
    FOREIGN KEY (BRAND_ID) REFERENCES Brand (ID),
    CONSTRAINT CAR_PRICE_NOT_LESS_THAN_ZERO CHECK (PRICE >= 0)
);

-- insert data into country
INSERT INTO Country
VALUES (1, 'Moldova', 'MDA'),
       (2, 'Mexico', 'MEX'),
       (3, 'Malta', 'MLT'),
       (4, 'Monaco', 'MCO'),
       (5, 'United States', 'USA'),
       (6, 'Vatican', 'VAT'),
       (7, 'Italy', 'ITA'),
       (8, 'Lebanon', 'LBN'),
       (9, 'Liberia', 'LBR'),
       (10, 'Madagascar', 'MDG'),
       (11, 'Laos', 'LAO'),
       (12, 'Japan', 'JPN'),
       (13, 'Israel', 'ISR'),
       (14, 'Germany', 'DEU'),
       (15, 'Georgia', 'GEO');


-- insert data into Brand
INSERT INTO Brand
VALUES (1, 'Ford', 5),
       (2, 'GMC', 5),
       (3, 'Chevrolet', 5),
       (4, 'Tesla', 5),
       (5, 'Fiat', 7),
       (6, 'Alfa Romeo', 7),
       (7, 'Maserati', 7),
       (8, 'Audi', 14),
       (9, 'BMW', 14),
       (10, 'Volkswagen', 14),
       (11, 'Toyota', 12),
       (12, 'Lexus', 12),
       (13, 'Suzuki', 12),
       (14, 'Mazda', 12),
       (15, 'Nissan', 12);

-- insert data into Car
INSERT INTO Car
VALUES (1, 'Model S60', 4, 'Red', '2019-03-15', 70000, 'Sedan'),
       (2, 'Model S P85', 4, 'Blue', '2020-01-10', 80000, 'Sedan'),
       (3, 'Focus', 1, 'Gray', '2020-01-10', 40000, 'Sedan'),
       (4, 'F-150', 1, 'Blue', '2010-08-12', 78000, 'Pickup Truck'),
       (5, 'IS', 12, 'Black', '2010-08-12', 55000, 'Sedan'),
       (6, 'RC', 12, 'Green', '2010-01-05', 55000, 'Coupe'),
       (7, 'UX', 12, 'Blue', '2015-08-01', 65000, 'SUV'),
       (8, 'Camry', 11, 'White', '2018-11-12', 25000, 'Sedan'),
       (9, 'Sequoia', 11, 'Gray', '2018-11-12', 85000, 'SUV'),
       (10, 'RAV4', 11, 'Blue', '22020-09-01', 35800, 'Sedan');

-- check constrains
DELETE FROM Car WHERE id = 11;
INSERT INTO Car VALUES (11, 'Model X', 4, 'Gray', '2019-03-15', -5, 'Sedan');  -- price can't be less than 0
INSERT INTO Car VALUES (11, NULL, 4, 'Gray', '2019-03-15', 27000, 'Sedan');  -- car name can't be null
INSERT INTO Car VALUES (11, 'Model X', 99, 'Gray', '2019-03-15', 27000, 'Sedan');  -- brand wiht id = 99 does not exists
INSERT INTO Car VALUES (11, 'Model X', 4, NULL, '2019-03-15', 27000, 'Sedan');  -- car color can be null

INSERT INTO Country VALUES (16, 'Moldova', 'MDA'); -- country name already exists
INSERT INTO Country VALUES (16, 'France', 'MDA');  -- country iso code already exists

INSERT INTO Brand VALUES (16, 'GMC', 5); -- brand name already exists
INSERT INTO Brand VALUES (16, 'Cadillac', 16); -- country id does not exists
INSERT INTO Brand VALUES (16, NULL, 5); -- brand name can't be null

-- queries
SELECT *
FROM CAR;

SELECT name, color, price
FROM CAR;

SELECT B.NAME, A.NAME, A.COLOR FROM Car A INNER JOIN Brand B ON A.BRAND_ID = B.ID;
SELECT B.NAME, COUNT(1) AS NUMBER_OF_MODELS FROM Car a INNER JOIN Brand B ON a.BRAND_ID = B.ID GROUP BY B.NAME;

-- alter table
ALTER TABLE Car
    ADD currency varchar(3) default 'EUR';
