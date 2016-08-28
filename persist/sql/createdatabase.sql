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

insert into functionnal.Person (nom, prenom, email) values ('MENHOUR', 'Merzouk', 'mmerzouk@gmail.com');
insert into functionnal.Users (login, password, email) values ('mmenhour', 'pmerzouk', 'mmerzouk@gmail.com');
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000001', 'mmerzouk@gmail.com', 123.45, false);
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000002', 'mmerzouk@gmail.com', 125.45, true);

insert into functionnal.Person (nom, prenom, email) values ('MENHOUR', 'Ryan', 'mryan@gmail.com');
insert into functionnal.Users (login, password, email) values ('mryan', 'pryan', 'mryan@gmail.com');
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000001', 'mryan@gmail.com', 223.45, false);
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000002', 'mryan@gmail.com', 10.45, true);

insert into functionnal.Person (nom, prenom, email) values ('MENHOUR', 'Assia', 'massia@gmail.com');
insert into functionnal.Users (login, password, email) values ('massia', 'passia', 'massia@gmail.com');
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000001', 'massia@gmail.com', 22.45, true);
insert into functionnal.Facture (numeroFacture, email, montant, factureReglee) values ('fac000000002', 'massia@gmail.com', 105.45, true);