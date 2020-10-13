-- ORDERING RESULTS

-- Populations of all countries in descending order

SELECT name, population FROM country ORDER BY population DESC;

--Names of countries and continents in ascending order

SELECT name, continent FROM country ORDER BY continent, name ASC;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.

SELECT name, lifeexpectancy AS average_life_expectancy FROM country WHERE lifeexpectancy IS NOT NULL ORDER BY lifeexpectancy DESC LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

SELECT name || ', ' || district AS citystate FROM city WHERE countrycode = 'USA' AND (district = 'California' OR district = 'Oregon' OR district = 'Washington') ORDER BY district, city;
SELECT name || ', ' || district AS citystate FROM city WHERE countrycode = 'USA' AND district IN ('California', 'Oregon', 'Washington') ORDER BY district, city;


-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World

SELECT 'World' AS Category, AVG(lifeexpectancy) AS average_life_expectancy FROM country;

-- Total population in Ohio

SELECT 'Ohio' AS Category, SUM(population) AS total_population FROM city WHERE district = 'Ohio';

-- The surface area of the smallest country in the world

SELECT name, surfacearea AS surface_area FROM country ORDER BY surfacearea ASC LIMIT 1; 

SELECT name, surfacearea FROM country WHERE surfacearea = (Select MIN(surfacearea) FROM country);

-- The 10 largest countries in the world

SELECT name FROM country ORDER BY surfacearea DESC LIMIT 10;

-- The number of countries who declared independence in 1991

SELECT COUNT(*) FROM country WHERE indepyear = 1991;

-- --------GROUP BY--------------
-- Count the number of countries where each language is spoken, ordered from most countries to least

SELECT language, count(*) AS countrycount FROM countrylanguage GROUP BY language ORDER BY countrycount DESC;

-- Average life expectancy of each continent ordered from highest to lowest

SELECT continent, AVG(lifeexpectancy) AS life_expectancy FROM country GROUP BY continent ORDER BY life_expectancy DESC;

-- Exclude Antarctica from consideration for average life expectancy

SELECT continent, AVG(lifeexpectancy) AS life_expectancy FROM country WHERE lifeexpectancy IS NOT null GROUP BY continent ORDER BY life_expectancy DESC;


-- Sum of the population of cities in each state in the USA ordered by state name

-- The average population of cities in each state in the USA ordered by state name

-- ---------SUBQUERIES----------------

-- Find the names of cities under a given government leader

SELECT c.name AS city_name FROM city c WHERE c.countrycode IN (SELECT code FROM country WHERE headofstate LIKE '%Elisabeth%') ;

-- Find the names of cities whose country they belong to has not declared independence yet

SELECT name, countrycode FROM city WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS null);

-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

SELECT * FROM city WHERE name = 'Arlington'; --How can we order there??

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

SELECT * FROM city ORDER BY population DESC;

SELECT * FROM city ORDER BY population DESC LIMIT 10 OFFSET 0;

SELECT * FROM city ORDER BY population DESC LIMIT 10 OFFSET 10;

SELECT * FROM city ORDER BY population DESC LIMIT 10 OFFSET 20;
-- USing OFFSET like this could be used to page through output



-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

-- Gets the MIN population and the MAX population from the city table.

SELECT COUNT(*) AS cities, MIN(population), MAX(population), AVG(population) FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
