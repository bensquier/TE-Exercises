-- INSERT

/* HOW WE ADD RECORDS TO TABLES */

-- 1. Add Klingon as a spoken language in the USA

SELECT * FROM countrylanguage WHERE language like '%ingon%';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA','Klingon',true, 75.0);

SELECT * FROM countrylanguage WHERE language like '%ingon%';

-- 2. Add Klingon as a spoken language in Great Britain

SELECT * FROM countrylanguage WHERE language like '%ingon%';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('GBR','Klingon',true, 75.0);

SELECT * FROM countrylanguage WHERE language like '%ingon%';

-- UPDATE: How we modify existing records

-- 1. Update the capital of the USA to Houston

/* ID'g the values */
SELECT code, capital FROM country WHERE code = 'USA';

SELECT * FROM city WHERE id = (SELECT capital FROM country WHERE code = 'USA');

SELECT * FROM city WHERE name = 'Houston';

/* Updating without hardcoding using subselects */

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Houston')
WHERE code = 'USA';

/* Validating my results */

SELECT 'This capital of ' || c.name || ' is ' || cty.name AS FriendlyCapital
FROM country c 
        INNER JOIN city cty
               ON c.capital = cty.id
WHERE
        c.code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state

/* WHAT IS THE ID FOR WASHINGTON?? */
SELECT * FROM city WHERE name = 'Washington';

/* We don't need the ID if we use a subquery (as long as it returns a single row) */
UPDATE country
SET 
        capital = (SELECT id FROM city WHERE name = 'Washington'),
        headofstate = 'Mark Wahberg'
WHERE code = 'USA';

/* Test the results */
SELECT 'This capital of ' || c.name || ' is ' || cty.name || ' and is run by ' || headofstate  AS FriendlyCapital 
FROM country c 
        INNER JOIN city cty
               ON c.capital = cty.id
WHERE
        c.code = 'USA';

-- DELETE

-- 1. Delete English as a spoken language in the USA

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM countrylanguage WHERE countrycode = 'USA' AND language = 'English';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- 2. Delete all occurrences of the Klingon language 

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM countrylanguage WHERE countrycode = 'USA' AND language = 'Klingon';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

SELECT * FROM countrylanguage;

INSERT INTO countrylanguage (language) VALUES ('Elvish');

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

INSERT INTO countrylanguage (language, countrycode) VALUES ('English', 'ZZZ');

-- 3. Try deleting the country USA. What happens?

DELETE FROM country WHERE code = 'USA';

SELECT * FROM city WHERE countrycode = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', 'Y', 90.0);
-- WHOA! Did you catch that implicit conversion of the 'Y' to the boolean True???
-- Lets play with that weird implicit conversion ...
UPDATE countrylanguage SET isofficial = 'Yes' WHERE language = 'English' and countrycode = 'USA';

-- 2. Try again. What happens?


INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', 'Y', 90.0);

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
        
        SELECT COUNT(*) FROM countrylanguage
        
ROLLBACK;
       
-- 2. Try updating all of the cities to be in the USA and roll it back

BEGIN TRANSACTION;

        SELECT COUNT(*) FROM city WHERE countrycode = 'USA';

        UPDATE city SET countrycode = 'USA';
        
        SELECT COUNT(*) FROM city WHERE countrycode = 'USA';
        
        SELECT * FROM city WHERE countrycode = 'USA';
        
ROLLBACK;   

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.

/* THIS WAS THE OPEN TRANSACTION IN DBViz AND ATTEMPTED TRANSACTION IN PGAdmin DEMO */
