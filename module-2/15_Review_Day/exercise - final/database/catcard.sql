BEGIN TRANSACTION; -- all commands run or no commands run
DROP TABLE IF EXISTS catcards;


CREATE TABLE catcards(
	cat_card_id SERIAL PRIMARY KEY,
	img_url VARCHAR(100) NOT NULL,
	cat_fact VARCHAR(100) NOT NULL,
	caption VARCHAR(100) NOT NULL
);

COMMIT;