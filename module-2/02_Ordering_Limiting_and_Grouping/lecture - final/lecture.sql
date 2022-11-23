-- ORDERING RESULTS

-- print out the whole table
-- SELECT columns FROM table_name WHERE column is something ORDER BY column either ASC or DESC
SELECT * FROM state;
-- Populations of all states from largest to smallest.
SELECT state_name, population
   FROM state
   ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region (ASC). The census regions are sorted in reverse alphabetical (Z-A) order (DESC).
SELECT state_name, census_region
   FROM state
   ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT park_name, area
   FROM park
   ORDER BY area DESC
   LIMIT 1;

SELECT park_name, area
   FROM park
   WHERE area = (SELECT max(area) FROM park);
   -- ("SELECT max(area) FROM park" - is a subquery)
-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
   FROM city
   ORDER BY population DESC
   LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

-- SELECT date_established FROM park;
SELECT park_name, date_part('year', date_established) AS years
   FROM park
   ORDER BY years, park_name
   LIMIT 20;
 -- can we extract the century -- Margaret can't remember that 19th century is the 1800s
 SELECT park_name, date_part('century', date_established) AS century
   FROM park
   ORDER BY century, park_name
   LIMIT 20;


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ', ' || state_abbreviation AS city_state
   FROM city;

-- The all parks by name and date established.  park : year
SELECT park_name || ': ' || date_part('year', date_established) AS year_established
   FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order. census_region : state_name
SELECT census_region || ': ' || state_name
   FROM state
   WHERE census_region = 'West' OR census_region = 'Midwest'
   ORDER BY census_region, state_name;

-- or another way to write this
SELECT census_region || ': ' || state_name
   FROM state
   WHERE census_region IN ('West', 'Midwest')
   ORDER BY census_region, state_name;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.

SELECT AVG(population) FROM state;
-- ROUND says first field is what you are rounding, the second (after the comma) is the scale -- how many decimal places to display
SELECT ROUND(AVG(population), 2) AS avg_population
   FROM state;

-- Total population in the West and South census regions
SELECT sum(population) AS total_population
   FROM state
   WHERE census_region IN ('West', 'South');
   
   -- ILIKE says contains case insensitive
   SELECT sum(population) AS total_population
   FROM state
   WHERE census_region ILIKE 'west' OR census_region ILIKE 'south';

-- The number of cities with populations greater than 1 million
-- could use COUNT(*) here as well
SELECT COUNT(population) AS big_cities
   FROM city
   WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*)
   FROM state
   WHERE state_nickname IS NOT NULL;
   
SELECT COUNT(state_nickname)
   FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
   FROM park;


-- lets see if we can add the park name -- not so easy!
SELECT park_name, area --MIN(area) AS smallest, MAX(area) AS largest
   FROM park
   WHERE area =  (SELECT MIN(area) FROM park) OR
   area = (SELECT MAX(area) FROM park);

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS city_count, state_abbreviation
   FROM city
   GROUP BY state_abbreviation
   ORDER BY city_count DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT * FROM park;

SELECT ROUND(AVG(area), 2), has_camping FROM park
	GROUP BY has_camping;
-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT SUM(population), state_abbreviation
   FROM city
   GROUP BY state_abbreviation
   ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT MIN(population), state_abbreviation
   FROM city
   GROUP BY state_abbreviation
   ORDER BY MIN(population);


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
   FROM city
   ORDER BY city_name
   OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

