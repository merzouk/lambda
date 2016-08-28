drop database functionnalTest;
create database functionnalTest;

create table functionnalTest.Person(
   id int NOT NULL AUTO_INCREMENT,
   nom varchar(50) NOT NULL,
   prenom varchar(50) NOT NULL,
   email varchar(150) NOT NULL,
   primary key(id)
);

create table functionnalTest.Users(
   id int NOT NULL AUTO_INCREMENT,
   login varchar(50) NOT NULL UNIQUE,
   password varchar(500) NOT NULL,
   email varchar(150) NOT NULL UNIQUE,
   primary key(id)
);

create table functionnalTest.Facture(
   id int NOT NULL AUTO_INCREMENT,
   numeroFacture varchar(50) NOT NULL,
   email varchar(150) NOT NULL,
   montant double NOT NULL,
   factureReglee BOOLEAN NOT NULL,
   primary key(id)
);