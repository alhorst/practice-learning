BEGIN TRANSACTION;

DROP TABLE IF EXISTS artist, customer, painting, invoice, invoice_painting CASCADE;
DROP SEQUENCE IF EXISTS artist_serial, customer_serial, painting_serial, invoice_serial;

CREATE SEQUENCE artist_serial;
CREATE TABLE artist (
   artist_id int NOT NULL DEFAULT nextval('artist_serial'),
   artist_name varchar(50) NOT NULL,
   CONSTRAINT PK_artist PRIMARY KEY(artist_id)
);

CREATE SEQUENCE customer_serial;
CREATE TABLE customer (
   customer_id int NOT NULL DEFAULT nextval('customer_serial'),
   customer_name varchar(50) NOT NULL,
   address varchar(100) NOT NULL,
   phone varchar (15),
   CONSTRAINT PK_customer PRIMARY KEY(customer_id)
);

CREATE SEQUENCE painting_serial;
CREATE TABLE painting (
   painting_id int NOT NULL DEFAULT nextval('painting_serial'),
   artist_id int NOT NULL,
   painting_title varchar (50) NOT NULL,
   year_painted date NOT NULL,
   price numeric (7, 2) NOT NULL,
   CONSTRAINT PK_painting PRIMARY KEY (painting_id),
   CONSTRAINT FK_artist_painting FOREIGN KEY (artist_id) REFERENCES artist (artist_id)
);

CREATE SEQUENCE invoice_serial;
CREATE TABLE invoice (
   invoice_id int NOT NULL DEFAULT nextval('invoice_serial'),
   buyer_id int NOT NULL,
   painting_id int NOT NULL,
   purchase_date date NOT NULL,
   sale_price numeric (7,2) NOT NULL,
   CONSTRAINT PK_invoice PRIMARY KEY (invoice_id),
   CONSTRAINT FK_customer_sale FOREIGN KEY (buyer_id) REFERENCES customer (customer_id),
   CONSTRAINT FK_painting_sale FOREIGN KEY (painting_id) REFERENCES painting (painting_id)
);

CREATE TABLE invoice_painting (
   invoice_id int NOT NULL,
   painting_id int NOT NULL,
   CONSTRAINT PK_invoice_painting PRIMARY KEY (invoice_id, painting_id),
   CONSTRAINT FK_invoice_painting_invoice FOREIGN KEY (invoice_id) REFERENCES invoice (invoice_id),
   CONSTRAINT FK_painting_invoice_painting FOREIGN KEY (painting_id) REFERENCES painting (painting_id)
);
INSERT INTO artist(artist_name) VALUES ('Sir John Coombe');
INSERT INTO painting(painting_title, year_painted, price, artist_id) VALUES ('Pastoral Scene', '1850-11-20', 2000.00, (1))
COMMIT;
