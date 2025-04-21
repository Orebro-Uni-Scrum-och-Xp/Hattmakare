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



Create table Försäljning(
    OID int,
    ProduktID int,
    OrderProduktID int,
    antal int,

    PRIMARY KEY (OrderProduktID),
    foreign key (OID) REFERENCES ordrar(OID),
    FOREIGN KEY (ProduktID) REFERENCES produkt(ProduktID)

)



Insert into personal
values (1, 'Otto', 'Hattmakare',2, 'otto@oru.se', '123',null),
(2, 'Judith','Hattmakare',2,'Judith@oru.se','456',null),
(3, 'Erik','Hattmakare',1,'erik@oru.se','456',null)



insert into material
values (1,'Kashmir','20','5000000','Meter')

insert into kund
values (1,'Diyar','Dynamit','Vivalla','Diyar@oru.se','112')



insert into ordrar
values (1,'Inte startad','2026-01-01',true,1);


insert into produkt
values (1,'Studentmössa',499,false,false)

insert into lagerfördahattar
    values (1,1,40000)

insert into försäljning
values(1,1,200,1);

insert into frakt
values (1,'Hattmakarna','Vivalla',150,'Studentmössor',1,1500,1)

insert into Produkt_material
values (1,1,1)

CREATE Table Beställning(
    BeställningsID int auto_increment primary key,
    Datum date,
    PersonalID int,
    FOREIGN KEY (PersonalID) REFERENCES personal(PID))


Create table Beställning_Material(
    MaterialID INT,
    BeställningsID int,
    mängd double (10,2),
    enhet varchar (50),
    pris double (10,2),
    PRIMARY KEY (BeställningsID, MaterialID),
    FOREIGN KEY (BeställningsID) REFERENCES beställning(BeställningsID),
    FOREIGN KEY (MaterialID) references material(MaterialID)
)

alter table material
    drop column pris,
    drop column enhet,
    drop column Mängd


Alter table material
add column pris varchar(50),
    add column enhet varchar(50);


Create table MaterialLista(
    MateriallistaID int auto_increment primary key,
    Namn varchar (50),
    Enhet varchar (50),
    mängd varchar(50),
    Pris varchar(50),
    MaterialID int,
    foreign key MaterialID(MaterialID) references material(MaterialID)


);



drop table beställning_material

CREATE TABLE beställning_material (
    BeställningsID INT,
    MateriallistaID INT,
    mängd VARCHAR(50),
    enhet VARCHAR(50),
    pris DECIMAL(10,2),
    PRIMARY KEY (BeställningsID, MateriallistaID),
    FOREIGN KEY (BeställningsID) REFERENCES beställning(BeställningsID),
    FOREIGN KEY (MateriallistaID) REFERENCES Materiallista(MateriallistaID)
);

select * from beställning_material

alter table beställning_material
drop column enhet,
    drop column mängd,
    drop column pris


alter table kund
add column personnummer varchar (13)

alter table produkt
add column bild varchar(100)


alter table produkt
add column beskrivning varchar(100)




create table personalorder(
    PersonalorderID int auto_increment primary key,
    Orderprodukter int,
    PID int,
    Datum date,
    Status varchar(50),

    foreign key (Orderprodukter)  references försäljning(OrderProduktID),
    foreign key (PID) REFERENCES produkt(ProduktID)
);

alter table beställning
add column status varchar(50)

alter table frakt
add column exportkod varchar(8);

Alter table personal
drop constraint personal_ibfk_1


alter table personal
drop column JobbarMed


