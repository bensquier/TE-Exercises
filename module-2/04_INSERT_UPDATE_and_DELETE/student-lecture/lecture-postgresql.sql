-- INSERT

-- 1. Add Klingon as a spoken language in the USA

SELECT * FROM countrylanguage WHERE language like '%ingon%';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA','Kliingon',true,75.0);

SELECT * FROM countrylanguage WHERE language like '%ingon%';

-- 2. Add Klingon as a spoken language in Great Britain

SELECT * FROM countrylanguage WHERE language like '%ingon%';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('GBR','Kliingon',true,75.0);

SELECT * FROM countrylanguage WHERE language like '%ingon%';


-- UPDATE

-- 1. Update the capital of the USA to Houston

SELECT code, capital FROM country WHERE code = 'USA'; --CHECKS TO FIND THE CAPITAL CODE

SELECT * FROM city WHERE id = (SELECT capital FROM country WHERE code = 'USA'); --FINDS ALL INFO ABOUT HOUSTON

SELECT * FROM city WHERE name = 'Houston'; --RETURNS THE CITY ID OF HOUSTON

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Houston') --UPDATES THE TABLE TO HAVE HOUSTON AS THE CAPITAL
WHERE code = 'USA';

SELECT code, capital FROM country WHERE code = 'USA'; -- CHECLS TO SEE IF IT WAS CHANGED

SELECT 'This capital of ' || c.name || ' is ' || cty.name AS FriendlyCapital
FROM country c
        INNER JOIN city cty
                ON c.capital = cty.id
WHERE c.code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state

SELECT * FROM city WHERE name = 'Washington';-- FINDS ALL DATA ABOUT WASHINGTON D.C.

UPDATE country
SET     
        capital = (SELECT id FROM city WHERE name = 'Washington'), -- SETS CAPITAL TO WASHINGTON D.C. AND HEAD OF STATE TO MARK WAHBERG
        headofstate = 'Mark Wahberg'
WHERE 
        code = 'USA';
        
        --TEST THE RESULTS--
SELECT 'This capital of ' || c.name || ' is ' || cty.name || ' and is ren by ' || headofstate AS FriendlyCapital
FROM country c
        INNER JOIN city cty
                ON c.capital = cty.id
WHERE c.code = 'USA';



-- DELETE

-- 1. Delete English as a spoken language in the USA

DELETE FROM countrylanguage
WHERE countrycode = 'USA' AND language = 'English';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- 2. Delete all occurrences of the Klingon language 

DELETE FROM countrylanguage
WHERE countrycode = 'USA' AND language = 'Kliingon';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

SELECT * FROM countrylanguage;

INSERT INTO countrylanguage (language) VAULES ('Elvish')

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

INSERT INTO countrylanguage (countrycode, language) VALUES ('ZZZ', 'English');

-- 3. Try deleting the country USA. What happens?

DELETE FROM country WHERE code = 'USA';

SELECT * FROM city WHERE countrycode = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', 'Y', 90.0);

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'

SELECT * FROM country WHERE code = 'USA';

UPDATE country SET continent = 'Outer Space' WHERE code = 'USA';

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

BEGIN TRANSACTION;

        SELECT * FROM countrylanguage;
        
        DELETE FROM countrylanguage;
        
        SELECT * FROM countrylanguage;
        
ROLLBACK;

-- 2. Try updating all of the cities to be in the USA and roll it back

BEGIN TRANSACTION;
        
                SELECT COUNT(*) FROM city WHERE countrycode = 'USA';
                
                UPDATE city SET countrycode = 'USA';
                
                SELECT * FROM city WHERE countrycode = 'USA';
                
ROLLBACK;

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.
/*
DELETE FROM countrylanguage WHERE language = 'Mahoré';
DELETE FROM countrylanguage WHERE language = 'Ketšua';
DELETE FROM countrylanguage WHERE language = 'Ketšua';
DELETE FROM countrylanguage WHERE language = 'Quiché';
DELETE FROM countrylanguage WHERE language = 'Náhuatl';
DELETE FROM countrylanguage WHERE language = 'Guaraní';
DELETE FROM countrylanguage WHERE language = 'Ketšua';
DELETE FROM countrylanguage WHERE language = 'Kabyé';
DELETE FROM countrylanguage WHERE language = 'Aimará';
DELETE FROM countrylanguage WHERE language = 'Aimará';
DELETE FROM countrylanguage WHERE language = 'Mantšu';
DELETE FROM countrylanguage WHERE language = 'Guaymí';
DELETE FROM countrylanguage WHERE language = 'Aimará';
DELETE FROM countrylanguage WHERE language = 'Guaraní';
DELETE FROM countrylanguage WHERE language = 'Kekchí';
DELETE FROM countrylanguage WHERE language = 'Tšam';
DELETE FROM countrylanguage WHERE language = 'Otomí';*/