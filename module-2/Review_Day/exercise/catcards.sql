BEGIN TRANSACTION;

DROP TABLE IF EXISTS catcards;

CREATE TABLE catcards (
	cat_card_id serial NOT NULL,
	img_url varchar(100) NOT NULL,
	cat_fact varchar(200) NOT NULL,
	caption varchar(200) NOT NULL,
	CONSTRAINT PK_cat_card_id PRIMARY KEY (cat_card_id)
);

COMMIT;