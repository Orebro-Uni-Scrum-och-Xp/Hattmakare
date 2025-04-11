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
Create table Kund
(
    KundID        int auto_increment primary key,
    Förnamn       varchar(50),
    Efternamn     varchar(50),
    Adress        varchar(50),
    Email         varchar(50),
    Telefonnummer VARCHAR(20)

);
    create table ordrar(
    OID int auto_increment primary key,
    Status varchar(50),
    Datum date,
    express boolean,
    KundID int,
    foreign key (KundID) references Kund(KundID))


Create table Personal(
    PID INT auto_increment  primary key,
    Förnamn varchar (50),
    Efternamn varchar (50),
    Behörighetsnivå int,
    Email varchar (50),
    Lösenord varchar (50),
    JobbarMed int,
    foreign key (JobbarMed) REFERENCES Ordrar(OID)



)

Create table Frakt(
    FraktID int auto_increment primary key,
    Avsändare varchar (50),
    Adress varchar(50),
    vikt double (10, 2),
    Beskrivning varchar (50),
    Mottagare int,
    Pris double (10,2),
    OID int,
    foreign key (Mottagare) references kund(kundID),
    foreign key (OID) references ordrar(OID)
)

create table produkt (
    ProduktID int auto_increment primary key,
    Namn varchar(50),
    pris double (10,2),
    Specialbeställning boolean,
    Flaggad boolean

)

Create table LagerfördaHattar(
    LagerfördID int auto_increment primary key,
    ProduktID int,
    Antal int,
    foreign key (ProduktID) references produkt(produktID)
)

-- Fuck you --

Create table material(
    MaterialID int auto_increment primary key,
    Namn varchar(50),
    Mängd double (10,2),
    Pris double (10,2),
    enhet varchar (50)
)

CREATE TABLE Produkt_material (
    ProduktID INT,
    MaterialID INT,
    Kvantitet VARCHAR(50),
    PRIMARY KEY (ProduktID, MaterialID),
    FOREIGN KEY (ProduktID) REFERENCES produkt(ProduktID),
    FOREIGN KEY (MaterialID) REFERENCES material(MaterialID)
);

Create table Order_produkter(
    OID int,
    ProduktID int,
    antal int,

    PRIMARY KEY (OID,ProduktID),
    foreign key (OID) REFERENCES ordrar(OID),
    FOREIGN KEY (ProduktID) REFERENCES produkt(ProduktID)

)


Rename Table Order_produkter to Försäljning



Insert into personal
values (1, 'Otto', 'Hattmakare',2, 'otto@oru.se', '123',null),
(2, 'Judith','Hattmakare',2,'Judith@oru.se','456',null),
(3, 'Erik','Hattmakare',1,'erik@oru.se','456',null)



insert into material
values (1,'Kashmir','20','5000000','Meter')

insert into ordrar
values (1,'Inte startad','2026-01-01',true,1,1)


insert into kund
values (1,'Diyar','Dynamit','Vivalla','Diyar@oru.se','112')

insert into ordrar
values (1,'Inte påbörjad','2026-01-01',false,1)

insert into produkt
values (1,'Studentmössa',499,false,false)

insert into lagerfördahattar
    values (1,1,40000)

insert into försäljning
values(1,1,200)

insert into frakt
values (1,'Hattmakarna','Vivalla',150,'Studentmössor',1,1500,1)

insert into Produkt_material
values (1,1,1)

