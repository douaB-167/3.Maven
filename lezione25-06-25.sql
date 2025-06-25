create database scuola; 
use scuola;

create table studente(
	studenteId int auto_increment primary key,
    nome varchar(100) not null,
    cognome varchar(100) not null, 
    matricola varchar(10) not null unique,
    dataNascita date not null
);

INSERT INTO studente(nome, cognome, matricola, dataNascita)
values 
("Mario", "Rossi", "SD00001","2000-05-14"),
("Ezio", "Rossi", "SD00002","1998-05-14"),
("Paolo", "Bianchi", "SD00003","1978-05-14"),
("Maria", "Verdi", "SD00004","2010-05-14"),
("Gino", "Pino", "SD00005","1999-05-14");

select * from studente;