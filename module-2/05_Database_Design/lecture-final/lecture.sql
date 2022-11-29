DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS artist;



start transaction;

CREATE TABLE customer(
	customer_id serial,
	customer_first_name varchar(50) not null,
	customer_last_name varchar(50) not null,
	customer_address varchar(100) not null,
	customer_phone varchar(15),
	constraint pk_customer_id primary key (customer_id)
);

CREATE TABLE artist(
	artist_id serial,
	first_name varchar(50) not null,
	last_name varchar(50),
	constraint pk_artist_id primary key (artist_id)
);

CREATE TABLE art(
	art_id serial,
	title varchar(100) not null,
	artistId int not null,
	constraint pk_art_id primary key (art_id),
	constraint fk_art_artist_id foreign key (artistId) references artist (artist_id)
);

CREATE TABLE purchase(
	purchase_id serial,
	customer_id int not null,
	art_id int not null,
	purchase_date timestamp not null,
	price money not null,
	constraint pk_purchase_id primary key (purchase_id),
	constraint fk_customer_id_customer foreign key (customer_id) references customer (customer_id),
	constraint fk_art_id_art foreign key (art_id) references art (art_id)
);


commit;
rollback;

INSERT INTO customer(customer_first_name, customer_last_name, customer_address, customer_phone)
VALUES ('rachelle', 'rauh', '123 sesame street', '(555) 555-5555');
INSERT INTO artist(first_name, last_name) VALUES('Ada', 'Safak');
INSERT INTO art(title,artistid) VALUES ('Sean', 1);

select * from customer;
select * from art;
