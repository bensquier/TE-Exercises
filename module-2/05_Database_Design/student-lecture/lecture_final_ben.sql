/* ART Gallery Creation Script*/

BEGIN TRANSACTION;

CREATE TABLE customer(

        id serial,
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        address varchar(255) NOT NULL,
        phone varchar(11) null,
        
        CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE artist(

        id serial,
        first_name varchar(50) NULL,
        last_name varchar(50) NOT NULL,
        
        CONSTRAINT pk_artist PRIMARY KEY (id)
);

CREATE TABLE art(

        id serial,
        title varchar(100) NOT NULL,
        artist_id int NOT NULL,
        
        CONSTRAINT pk_art PRIMARY KEY (id)
);

CREATE TABLE customer_purchase(

        customer_id int NOT NULL,
        art_id int NOT NULL,
        purchase_date timestamp NOT NULL,
        price money NOT NULL,
        
        CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id, art_id, purchase_date)
);



/* ALTER STATEMENTS TO ADD FORIEIGN KEYS AS PER PATTERN*/

ALTER TABLE art
ADD CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist(id);


ALTER TABLE customer_purchase
ADD CONSTRAINT fk_customer_purchase_art FOREIGN KEY (art_id) REFERENCEs art(id);

ALTER TABLE customer_purchase
ADD CONSTRAINT fk_customer_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer(id);

COMMIT;

--ADD SOME STUFF TO THE TABLES

BEGIN TRANSACTION;

INSERT INTO artist(first_name, last_name) VALUES ('Carol', 'Channing');
INSERT INTO artist(first_name, last_name) VALUES ('Dennis', 'Frings');

INSERT INTO art(title, artist_id) VALUES ('Laugh with gums', (SELECT id FROM artist WHERE first_name = 'Carol' AND last_name = 'Channing'));
INSERT INTO art(title, artist_id) VALUES ('At the Talkies', (SELECT id FROM artist WHERE first_name = 'Carol' AND last_name = 'Channing'));

COMMIT;