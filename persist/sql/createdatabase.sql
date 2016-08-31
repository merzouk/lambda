drop database functionnal;
create database functionnal;

create table functionnal.Person(
   id int NOT NULL AUTO_INCREMENT,
   nom varchar(50) NOT NULL,
   prenom varchar(50) NOT NULL,
   email varchar(150) NOT NULL,
   primary key(id)
);

create table functionnal.Users(
   id int NOT NULL AUTO_INCREMENT,
   login varchar(50) NOT NULL UNIQUE,
   password varchar(500) NOT NULL,
   email varchar(150) NOT NULL UNIQUE,
   primary key(id)
);

create table functionnal.Facture(
   id int NOT NULL AUTO_INCREMENT,
   numeroFacture varchar(50) NOT NULL,
   email varchar(150) NOT NULL,
   montant double NOT NULL,
   factureReglee BOOLEAN NOT NULL,
   primary key(id)
);

-- Insert your data for the all tests.
