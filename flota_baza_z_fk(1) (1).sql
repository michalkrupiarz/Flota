Drop Table alerty;
drop table decyzja;
drop table waznosc;
drop table alerty_rodzaj;
Drop table alerty_status;
drop table umowy_leasing;
drop table grupa_limit;
drop table ubezpieczenie;
drop table historia_alertow;
drop table import;
drop table wypozyczenie;
drop table typ_samochod;
Drop Table pracownik;
DROP TABLE samochod;
drop table rodzaj_pojazdu;
drop table samochod_status;
Drop Table opony_status;
drop table karta_paliwowa;
drop table karta_paliwowa_statusy;
drop table karta_parkingowa;
drop table karta_parkingowa_statusy;
drop table lokalizacja;
drop table uprawnienia;
drop table dzial;
Drop table stanowisko;
drop table terminarz_wypozyczen;
drop table tytul_potracenia;


create table decyzja
(
	"id_decyzja" bigserial primary key,
	"nazwa" varchar(1000) not null,
	"id_import" integer	
);

insert into decyzja(nazwa)
values ('brak'),
	   ('zgoda'),
	   ('odmowa'),
	   ('odrzucenie');

create table waznosc
(
  "id_waznosc" bigserial primary key,
  "nazwa_waznosc" varchar(1000),
  "id_importu" integer
);

Insert into waznosc (id_waznosc,nazwa_waznosc)
values  (1, 'priorytetowa'),
		(2,'bardzo wysoksa'),
		(3,'wysoka'),
		(4,'srednia'),
		(5,'niska'),
		(6,'bardzo niska');

create table alerty_rodzaj
(
  "id_alerty_rodzaj" bigserial primary key,
  "nazwa_alerty_rodzaj" varchar(1000) not null,
  "id_importu" integer
);

INSERT INTO alerty_rodzaj(
            id_alerty_rodzaj, nazwa_alerty_rodzaj)
    VALUES  (1,'wypożyczenie'),
			(2,'użyczenie'),
			(3,'awaria'),
			(4,'wypadek'),
			(5,'wymiana opon'),
			(6,'naprawa'),
			(7,'przegląd rejestracyjny'),
			(8,'przegląd - inny'),
			(9,'ubezpieczenie'),
			(10,'wprowadzenie do użytku'),
			(11,'usunięcie z używania'),
			(12,'zaginiony'),
			(13,'skradziony'),
			(14,'skasowany'),
			(15,'wolny');

Create Table alerty_status
(
  "id_alerty_status" bigserial primary key,
  "nazwa_alerty_status" varchar(1000) not null,
  "id_import" integer
);

INSERT INTO alerty_status(
            id_alerty_status, nazwa_alerty_status)
    VALUES (1,'nowy'),
(2,'w toku'),
(3,'zakończony'),
(4,'ponownie otwarty');

create table uprawnienia (
"id_uprawnienia" bigserial primary key,
"nazwa" varchar(1000),
"id_import" integer
);
		
insert into uprawnienia (id_uprawnienia, nazwa)
values
(1,'uzytkownik'),
(2,'pracownik'),
(3,'pracownik_administracji'),
(4,'admin');

create table lokalizacja
(
  "id_lokalizacja" bigserial primary key,
  "nazwa_lokalizacja" varchar(1000) not null,
  "id_import" integer
);

insert into lokalizacja(id_lokalizacja,nazwa_lokalizacja)
values 
		(1,'Wrocław'),
		(2,'Warszawa');




create table dzial 
(
  "id_dzial" bigserial primary key,
  "nazwa_dzial" varchar(1000) not null,
  "id_importu" integer
);

INSERT INTO dzial(
            id_dzial, nazwa_dzial)
    VALUES  (1,'administracja'),
			(2,'księgowość'),
			(3,'IT'),
			(4,'marketing'),
			(5,'sprzedaż');
			
 Create Table stanowisko
 (
   "id_stanowisko" bigserial primary key,
   "nazwa_stanowisko" varchar(1000) not null,
   "id_importu" integer
 );

insert into stanowisko(id_stanowisko,nazwa_stanowisko)
values 
			(1,'specjalista'),
			(2,'kierownik'),
			(3,'dyrektor'),
			(4,'młodszy specjalista'),
			(5,'starszy specjalista');

CREATE TABLE samochod_status 
(
	"id_samochod_status" bigserial primary key,
	"nazwa_samochod_status" varchar(1000) NOT NULL
);

Insert into samochod_status(id_samochod_status,nazwa_samochod_status)
values
		(1,'wolny'),
		(2,'wypożyczony'),
		(3,'użyczony'),
		(4,'awaria'),
		(5,'naprawa'),
		(6,'wymiana kół'),
		(7,'przegląd'),
		(8,'zwrot');
		
CREATE TABLE opony_status
(
  "id_opony_status" bigserial primary key,
  "nazwa_opony_status" varchar(1000) NOT NULL,
  "id_import" integer
);

Insert into opony_status
	(id_opony_status,nazwa_opony_status)
values
		(1,'letnie '),
		(2,'zimowe'),
		(3,'dojazdówka'),
		(4,'wymiana'),
		(5,'awaria');
		
CREATE TABLE karta_paliwowa_statusy
(
  "id_karta_paliwowa_statusy"  bigserial primary key,
  "status_karta_paliwowa_statusy" varchar(1000) NOT NULL,

  "id_importu" integer
);

Insert into karta_paliwowa_statusy(id_karta_paliwowa_statusy, status_karta_paliwowa_statusy)
	Values 
			(1,'wolna'),
			(2,'używana'),
			(3,'zagubiona'),
			(4,'używana'),
			(5,'zwrot');
  
CREATE TABLE karta_parkingowa_statusy
(
  "id_karta_parkingowa_statusy"   bigserial primary key ,
  "status_karta_parkingowa_statusy" varchar(1000) NOT NULL,
  "id_importu" integer
);

Insert into karta_parkingowa_statusy(id_karta_parkingowa_statusy,status_karta_parkingowa_statusy)
values
		(1,'wolna'),
		(2,'używana'),
		(3,'zagubiona'),
		(4,'używana'),
		(5,'zwrot');


create table rodzaj_pojazdu 
(
 "id_rodzaj_pojazdu" bigserial primary key,
 "nazwa" varchar(1000) not null,
 "id_importu" integer
);

Insert into rodzaj_pojazdu (nazwa)
values
('wlasny'),
('wypozyczony');

create table historia_alertow
(
		"id_historia_alertow" bigserial primary key,
		"id_alertu" integer,
		"data_wpisu" date not null,
		"alert_status_historyczny" integer not null,
		"alert_status_wiodacy" integer not null
);

create table wypozyczenie
(
  "id_wypozyczenia" bigserial primary key,
  "id_alertu" integer not null,
  "tresc_zlecenia" varchar(10000) not null,
  "id_zlecajacego" integer not null,
  "id_pracownika_realizujacego" integer not null,
  "data_zlecenia" date not null,
  "data_przyjecia_zlecenia" date not null,
  "data_zakonczenia_zlecenia" date not null,
  "id_pojazdu" integer not null,
  "id_pracownika_wypozyczajacego" integer not null,
  "id_lokalizacja" varchar(1000)
);

Create Table pracownik
(
 "id_pracownik" bigserial primary key,
 "login" varchar(1000) unique not null,
 "haslo" varchar(1000) not null,
 "imie" varchar(1000) not null,
 "nazwisko" varchar(1000) not null,
 "id_stanowisko" integer not null,
 "id_dzial" integer not null,
 "id_lokalizacja" integer not null,
 "mail" varchar(1000),
 "tel_stac" integer,
 "tel_kom" integer,
 "id_samochod" integer,
 "id_import" integer,
 "id_uprawnienia" integer not null default 1,
 constraint fk_id_stanowisko foreign key (id_stanowisko) references stanowisko(id_stanowisko),
 constraint fk_id_dzial foreign key (id_dzial) references dzial(id_dzial),
 constraint fk_id_lokalizacja foreign key (id_lokalizacja) references lokalizacja(id_lokalizacja),
 
 constraint fk_id_uprawnienia foreign key (id_uprawnienia) references uprawnienia(id_uprawnienia)
 );

insert into pracownik(id_pracownik,login,haslo,imie,nazwisko,id_stanowisko,id_dzial,id_lokalizacja,mail,tel_stac,tel_kom,id_samochod)
values
		(1,'Adam Adamowski','Adam Adamowski','Adam','Adamowski',1,1,1,'Adam.Adamowski@firma.pl',711234567,660660660,0),
		(2,'Bogdan Bogdanowski','Bogdan Bogdanowski','Bogdan','Bogdanowski',2,2,2,'Bogdan.Bogdanowski@firma.pl',221234567,661661661,0),
		(3,'Cezary Cezarycki','Cezary Cezarycki','Cezary','Cezarycki',3,3,1,'Cezary.Cezarycki@firma.pl',711234567,660660660,0),
		(4,'Damian Damianowski','Damian Damianowski','Damian','Damianowski',4,4,2,'Damian.Damianowski@firma.pl',221234567,661661661,0),
		(5,'Eryk Wiking','Eryk Wiking','Eryk','Wiking',5,5,1,'Eryk.Wiking@firma.pl',711234567,660660660,0),
		(6,'Franciszek Franc','Franciszek Franc','Franciszek','Franc',1,1,2,'Franciszek.Franc@firma.pl',221234567,661661661,0);

Create Table alerty
(
  "id_alerty" bigserial primary key,
  "data_dodania" date not null,
  "data_przypisania" date,
  "id_rodzaj" integer not null,
  "id_status" integer not null,
  "id_waznosc" integer not null,
  "data_zamkniecia" date,
  "opis" varchar(10000),
  "id_uzytkownika_zlecajacego" integer not null,
  "id_uzytkownika_realizujacego" integer,
  "identyfikator_wiodacy" integer not null default 0,
  "identyfikator_historii" integer not null default 1,
  "akceptacja_kosztow" integer,
  "id_import" integer,
  "id_decyzja_dzialu_administracji" integer not null default 1,
  "id_decyzja_dzialu_kosztow" integer not null default 1,
  constraint fk_id_rodzaj foreign key (id_rodzaj) references alerty_rodzaj (id_alerty_rodzaj),
  constraint fk_id_status foreign key (id_status) references alerty_status (id_alerty_status),
  constraint fk_id_waznosc foreign key (id_waznosc) references waznosc (id_waznosc),
  constraint fk_id_uzytkownika_zlecajacego foreign key (id_uzytkownika_zlecajacego) references pracownik (id_pracownik),
  constraint fk_id_uzytkownika_realizujacego foreign key (id_uzytkownika_realizujacego) references pracownik (id_pracownik),
  constraint fk_id_decyzja_dzialu_administracji foreign key (id_decyzja_dzialu_administracji) references decyzja(id_decyzja),
  constraint fk_id_Decyzja_dzialu_kosztow foreign key (id_decyzja_dzialu_kosztow) references decyzja(id_decyzja)
);

insert into alerty (id_alerty,data_dodania,id_rodzaj,id_status,id_waznosc,id_uzytkownika_zlecajacego,identyfikator_wiodacy,identyfikator_historii,id_decyzja_dzialu_administracji,id_decyzja_dzialu_kosztow)
values
		(1,'2015-01-11',1,1,1,1,0,0,1,1),
		(2,'2015-01-20',1,1,1,1,0,0,1,1),
		(3,'2015-01-29',1,1,1,1,0,0,1,1),
		(4,'2015-02-11',1,1,1,1,0,0,1,1);

CREATE TABLE karta_paliwowa
(
  "id_karta_paliwowa" bigserial primary key,
  "id_status_paliwowa" integer NOT NULL,
  "id_lokalizacja_paliwowa" integer NOT NULL,
  "numer_karty" varchar(1000) unique NOT NULL,
  "pin_karty" varchar(1000) not null,
  "id_importu" integer,
  constraint fk_id_status foreign key (id_status_paliwowa) references karta_paliwowa_statusy (id_karta_paliwowa_statusy),
  constraint fk_id_lokalizacja foreign key (id_lokalizacja_paliwowa) references lokalizacja(id_lokalizacja)
  
);

insert into karta_paliwowa (id_karta_paliwowa,id_status_paliwowa,id_lokalizacja_paliwowa,numer_karty,pin_karty)
values
		(1,1,1,'paliwowa karta 1',1),
		(2,1,2,'paliwowa karta 2',2),
		(3,1,1,'paliwowa karta 3',3),
		(4,1,2,'paliwowa karta 4',4),
		(5,1,1,'paliwowa karta 5',5),
		(6,1,2,'paliwowa karta 6',6),
		(7,1,1,'paliwowa karta 7',7);

create table karta_parkingowa
(
  "id_karta_parkingowa"   bigserial primary key , 
  "id_status_parkingowa" integer NOT NULL,
  "id_lokalizacja_parkingowa" integer NOT NULL,
  "numer_karta_parkingowa" varchar(1000) unique NOT NULL,
  "id_importu" integer,
   constraint fk_id_status foreign key (id_status_parkingowa) references karta_parkingowa_statusy (id_karta_parkingowa_statusy),
  constraint fk_id_lokalizacja foreign key (id_lokalizacja_parkingowa) references lokalizacja(id_lokalizacja)
);

insert into karta_parkingowa(id_karta_parkingowa,id_status_parkingowa,id_lokalizacja_parkingowa,numer_karta_parkingowa)
values
		(1,1,1,'parkingowakarta1'),
		(2,1,1,'parkingowakarta2'),
		(3,1,1,'parkingowakarta3'),
		(4,1,1,'parkingowakarta4'),
		(5,1,1,'parkingowakarta5'),
		(6,1,1,'parkingowakarta6'),
		(7,1,1,'parkingowakarta7');

create table typ_samochod
  (
	"id_typ_samochod" bigserial primary key,
	"nazwa" varchar(1000) not null default 'osobowy',
	"id_import" integer
  );
  
  insert into typ_samochod(nazwa)
  values
	('osobowy'),
	('ciężarowy');	

create table grupa_limit
(
	"id_grupa_limit" bigserial primary key,
	"nazwa" varchar(1000) not null,
	"id_import" integer
);

insert into grupa_limit("nazwa")
values
	('bonus'),
	('narzędzie pracy'),
	('teren');	



CREATE TABLE samochod
(
	"id_samochod" bigserial primary key,
	"nazwa" varchar(1000) not null,
	"marka" varchar(1000) NOT NULL,
	"model" varchar(1000) NOT NULL,
	"oznaczenie_producenta" varchar(1000) NOT NULL,
	"paliwo" varchar(1000) NOT NULL,
	"poj_silnika" varchar(1000) NOT NULL,
	"rok_produkcji" integer not null,
	"data_przyjecia" date  default current_date ,
	"data_pierwszej_rejestracji" date,
	"id_gps" integer,
	"nr_rej" varchar(1000) NOT NULL,
	"nr_vin" varchar(1000) NOT NULL,
	"id_status" integer NOT NULL,
	"id_opony_status" integer NOT NULL,
	"id_lokalizacja" integer not null default 1,
	"id_lokalizacja_stala" integer NOT NULL default 1,
	"id_rodzaj_pojazdu" integer not null,
	"id_karta_parkingowa" integer default 1,
	"id_karta_paliwowa" integer default 1,
	"id_importu" integer,
	"kilometry" float default 0,
	"przebieg_calkowity" float default 0,
	"kolor" varchar(1000),
	"wersja" varchar(1000),
	"id_typ_samochod" integer not null default '1',
	"vat" varchar(1000) not null default 'tak',
	"id_grupa_limit" integer not null default '2',
	"nr_umowy_leasingu" varchar(1000) not null,
	"nr_umowy_serwis" varchar(1000),
	"mpk" varchar(1000),
	"prv_umowa" varchar(1000),
	"umowa_z_dnia" date default current_date,
	"miejsce_parkingowe" varchar(1000),
	"rozmiar_opon" float not null,
	constraint fk_id_status foreign key (id_status) references samochod_status(id_samochod_status), 
	constraint fk_id_opony_status foreign key (id_opony_status) references opony_status(id_opony_status),
	constraint fk_id_lokalizacja foreign key (id_lokalizacja) references lokalizacja (id_lokalizacja),
	constraint fk_id_lokalizacja_stala foreign key (id_lokalizacja_stala) references lokalizacja(id_lokalizacja),
	constraint fk_id_rodzaj_pojazdu foreign key (id_rodzaj_pojazdu) references rodzaj_pojazdu(id_rodzaj_pojazdu),
	constraint fk_id_karta_parkingowa foreign key (id_karta_paliwowa) references karta_parkingowa (id_karta_parkingowa),
	constraint fk_id_karta_paliwowa foreign key (id_karta_paliwowa) references karta_paliwowa (id_karta_paliwowa),
	constraint fk_id_typ_samochod foreign key(id_typ_samochod) references typ_samochod(id_typ_samochod),
	constraint fk_id_grupa_limit foreign key (id_grupa_limit) references grupa_limit(id_grupa_limit)
	
);



 
Insert into samochod(id_samochod,nazwa,marka,model,oznaczenie_producenta,paliwo,poj_silnika,rok_produkcji,nr_rej,nr_vin,id_status,id_opony_status,id_lokalizacja,id_lokalizacja_stala,id_rodzaj_pojazdu, nr_umowy_leasingu,rozmiar_Opon)  
values	
		(1,'auto1','Opel','Astra','XXAstraX1','benzyna','1.6',2014,'DW 10001','ASXD12345',1,1,1,1,1,'umowa1',17),
		(2,'auto2','Opel','Astra','XXAstraX2','benzyna','1.6',2013,'DW 10002','ASXD12346',1,1,1,1,1,'umowa2',17),
		(3,'auto3','Opel','Astra','XXAstraX3','benzyna','1.6',2012,'DW 10003','ASXD12347',1,1,1,1,1,'umowa3',16),
		(4,'auto4','Opel','Astra','XXAstraX4','benzyna','1.6',2015,'DW 10004','ASXD12348',1,1,1,1,1,'umowa4',16);

		update samochod set 
data_pierwszej_rejestracji='2015-03-12',kolor='niebieski',wersja='sedan',nr_umowy_serwis='serwis1',mpk='12',prv_umowa='prv_u_1',miejsce_parkingowe='miejsce_1'
where id_samochod = 1

update samochod set 
data_pierwszej_rejestracji='2015-03-12',kolor='niebieski',wersja='sedan',nr_umowy_serwis='serwis1',mpk='12',prv_umowa='prv_u_1',miejsce_parkingowe='miejsce_1'
where id_samochod = 2

update samochod set 
data_pierwszej_rejestracji='2015-03-12',kolor='niebieski',wersja='sedan',nr_umowy_serwis='serwis1',mpk='12',prv_umowa='prv_u_1',miejsce_parkingowe='miejsce_1'
where id_samochod = 3

update samochod set 
data_pierwszej_rejestracji='2015-03-12',kolor='niebieski',wersja='sedan',nr_umowy_serwis='serwis1',mpk='12',prv_umowa='prv_u_1',miejsce_parkingowe='miejsce_1'
where id_samochod = 4

update samochod set
id_gps = 1
where id_samochod = 1

update samochod set
id_gps = 1
where id_samochod = 2

update samochod set
id_gps = 1
where id_samochod = 3

update samochod set
id_gps = 1
where id_samochod = 4
		
create table ubezpieczenie

(
  "id_ubezpieczenie"   bigserial primary key ,
  "id_samochodu" integer not null,
  "data_rozpoczecia" date not null,
  "data_zakonczenia" date not null,
  "data_zawarcia" date not null,
  "ubezpieczyciel" varchar(1000) not null,
  "skladka" money not null,
  "id_operator_zawierajacy" integer not null,
  "notatka" varchar(1000),
  "numer_polisy" varchar(1000) not null,
  "nazwa_sprzedawcy" varchar (1000),
  "kontakt" varchar (1000),
  constraint fk_id_samochod foreign key (id_samochodu) references samochod(id_samochod),
  constraint fk_id_operator_zawierajacy foreign key (id_operator_zawierajacy) references pracownik (id_pracownik)
  
);

Alter table ubezpieczenie
  owner to postgres;

insert into ubezpieczenie (id_ubezpieczenie,id_samochodu,data_rozpoczecia,data_zakonczenia,data_zawarcia,ubezpieczyciel,skladka,id_operator_zawierajacy,numer_polisy,nazwa_sprzedawcy,kontakt)  
values 
		(1,1,'2014-01-01','2014-12-01','2013-12-30','PZU','1200',1,'az1234','Pan z PZU','717654321'),
		(2,2,'2014-01-02','2014-12-02','2013-12-30','PZU','1600',1,'az1235','Pan z PZU','717654321'),
		(3,3,'2014-01-03','2014-12-03','2013-12-30','PZU','1000',1,'az1236','Pan z PZU','717654321'),
		(4,4,'2014-01-04','2014-12-04','2013-12-30','PZU','1000',1,'az1237','Pan z PZU','717654321');


create table import
(
  "id_import"  bigserial primary key,
  "numer_importu" integer not null unique,
  "opis" varchar(1000) not null
  );
  
  


	

create table umowy_leasing(
	"id_umowy_leasingu" bigserial primary key,
	"numer_umowy_leasingu" varchar(1000) not null,
	"rata_leasingu" float,
	"data_platnosci" date,
	"id_samochod" integer,
	"import" integer	);
insert into umowy_leasing(
	"numer_umowy_leasingu","rata_leasingu","data_platnosci","id_samochod"
)
values
	('umowaleasingunr1',1200.00,'2015-04-30','1');



create table tytul_potracenia (
	"id_tytul_potracenia" bigserial not null unique,
	"tytul_potracenia_nazwa" varchar(1000) not null,
	"import" integer);


Insert into tytul_potracenia(
	"tytul_potracenia_nazwa")
	values ('uzytkowanie_prywatne'),('zlamanie_regulaminu'),('inne');
	
create table potracenia_samochod(
	"id_potracenia" bigserial primary key,
	"id_tytul_potracenia" integer not null,
	"data_potracenia" date not null,
	"wysokosc_potracenia" float not null,
	"id_samochod" integer,
	"id_pracownika" integer,
	"id_import" integer,
	
	constraint fk_id_tytul_potracenia foreign key(id_tytul_potracenia) references tytul_potracenia(id_tytul_potracenia)
	);
	
Insert into potracenia_samochod
 ("id_tytul_potracenia","data_potracenia","wysokosc_potracenia","id_samochod","id_pracownika")
 
 values('1','2014-01-01','120.2','1','1');
 
 create table terminarz_wypozyczen(
	"id_dnia" bigserial primary key
	,"data" date not null
	,"1" integer
	,"2" integer,
	"3" integer,
	"4" integer,
	"5" integer);
 