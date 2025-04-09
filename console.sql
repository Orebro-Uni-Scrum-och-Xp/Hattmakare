-- Skript

-- använder default databasschemat för att kunna köra koden nedan
use mysql;

-- Ta bort proceduren om den redan finns, möjliggör att köra om koden igen utan krångel
DROP PROCEDURE IF EXISTS setup_hattmakaren;
DELIMITER //


-- Skapar en procedure som kan köras för att skapa ett databasschema och en användare och ger användaren rättigheter till schemat.
-- Om databasschemat finns sedan tidigare tas det bort och återskapas
-- Om användare finns skapar inte användaren igen.
CREATE PROCEDURE setup_hattmakaren()
BEGIN
    DECLARE user_exists INT DEFAULT 0;
     -- Kontrollera om användaren 'dbAdmin2024'@'localhost' finns
    SELECT COUNT(*) INTO user_exists
    FROM mysql.user
    WHERE user = 'dbHattAdmin' AND host = 'localhost';

    -- Skapa databasen om den inte redan finns
    DROP DATABASE IF EXISTS hattmakaren;
    CREATE DATABASE hattmakaren;


    -- Om användaren inte finns, skapa användaren och tilldela behörigheter
    IF user_exists = 0 THEN
        CREATE USER 'dbHattAdmin'@'localhost' IDENTIFIED BY 'dbHattAdminPW';
        GRANT ALL PRIVILEGES ON hattmakaren.* TO 'dbHattAdmin'@'localhost';
        FLUSH PRIVILEGES;
    END IF;
END;
//
DELIMITER ;
-- Kör proceduren
call setup_hattmakaren();

-- Ställer in så att kod nedan för detta komma köras mot det nyskapta databasschemat
USE hattmakaren;


CREATE TABLE Kund (
    KID INT AUTO_INCREMENT PRIMARY KEY,
    Namn VARCHAR(50),
    Adress VARCHAR(50),
    TelefonNr VARCHAR(10),
    Email VARCHAR(50),
    Prisinklmoms DECIMAL(10,2),
    Exportkod VARCHAR(50)
);

-- Tabell: Frakt
CREATE TABLE Frakt (
    FRID INT AUTO_INCREMENT PRIMARY KEY,
    Adress VARCHAR(50),
    Avsändare VARCHAR(50),
    Mottagare VARCHAR(50),
    Vikt DECIMAL(10,2),
    Innehåll VARCHAR (200),
    Pris DECIMAL(10,2)
);

-- Tabell: Order
CREATE TABLE Ordrar (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    Status VARCHAR(50),
    Datum DATE,
    Pris DECIMAL(10,2),
    Material VARCHAR(100),
    EXPRESS BOOLEAN DEFAULT FALSE,
    KID INT,
    FRID INT,
    FOREIGN KEY (KID) REFERENCES Kund(KID),
    FOREIGN KEY (FRID) REFERENCES Frakt(FRID)
);

-- Tabell: Personal
CREATE TABLE Personal (
    PID INT AUTO_INCREMENT PRIMARY KEY,
    Förnamn VARCHAR (50),
    Efternamn VARCHAR(50),
    Behörighetsnivå VARCHAR(50),
    Email VARCHAR(100),
    Lösenord VARCHAR(50)
);

-- Tabell: Inloggning
CREATE TABLE Inloggning (
    IID INT AUTO_INCREMENT PRIMARY KEY,
    PID INT,
    Email VARCHAR(100),
    Lösenord VARCHAR(50),
    FOREIGN KEY (PID) REFERENCES Personal(PID)
);

-- Tabell: Försäljningsstatistik
CREATE TABLE Försäljningsstatistik (
    FID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    Summa DECIMAL(10,2),
    FOREIGN KEY (OrderID) REFERENCES Ordrar(OrderID)
);

-- Relationstabell: Order skapas av Kund (many-to-one)
-- Redan modellerat i Order-tabellen med KID

-- Relationstabell: Order jobbas med av Personal (many-to-many)
CREATE TABLE Order_Personal (
    OrderID INT,
    PID INT,
    PRIMARY KEY (OrderID, PID),
    FOREIGN KEY (OrderID) REFERENCES Ordrar(OrderID),
    FOREIGN KEY (PID) REFERENCES Personal(PID)
);
SELECT * FROM Ordrar;

INSERT INTO Kund (Namn, Adress, TelefonNr, Email, Prisinklmoms, Exportkod)
VALUES
('Anna Andersson', 'Storgatan 1', '0701234567', 'anna@example.com', 199.90, 'EX123'),
('Björn Björk', 'Lillgatan 2', '0709876543', 'bjorn@example.com', 299.90, 'EX456');

SELECT * FROM Kund
UPDATE Kund
SET Namn = 'Diyar',
    Adress = 'Örebro',
    TelefonNr = '0702229381',
    Email = 'diyar@oru.se',
    Prisinklmoms = 185.00,
    Exportkod = 'EX484'
WHERE KID = 1;

SELECT * FROM Kund;



SELECT * FROM Kund

UPDATE Kund
SET Namn = 'Alex',
    Adress = 'Örebro',
    TelefonNr = '0702228392',
    Email = 'alex@oru.se',
    Prisinklmoms = 165.00,
    Exportkod = 'EX584'
WHERE KID = 2;
SELECT * FROM Kund;


SELECT * FROM Personal;
INSERT INTO Personal (Förnamn, Efternamn, Behörighetsnivå, Email,Lösenord)
VALUES
('Erik','Hattmakare','Medarbetare','erik@oru.se','789');




DROP TABLE Inloggning;

SELECT * FROM Personal;
UPDATE Personal
SET Lösenord = ('123') WHERE PID = 1;
UPDATE Personal
SET Lösenord = ('456') WHERE PID = 2;


ALTER TABLE Kund
DROP COLUMN Prisinklmoms;

SELECT * FROM Kund;




CREATE TABLE Material(
MaterialID INT AUTO_INCREMENT PRIMARY KEY,
Materialnamn VARCHAR (50),
Materiallängd DOUBLE (10,3));

CREATE TABLE Produkt(
ProduktID INT AUTO_INCREMENT PRIMARY KEY,
Produktnamn VARCHAR (50),
Material VARCHAR (50),
Mått VARCHAR (50),
Antal INT,
MaterialID INT,
FOREIGN KEY (MaterialID) REFERENCES Material(MaterialID));

SELECT * FROM Produkt;

SELECT * FROM Material;

SHOW TABLES;














