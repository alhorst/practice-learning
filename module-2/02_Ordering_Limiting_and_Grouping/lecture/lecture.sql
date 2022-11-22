-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
   FROM state
   ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
   FROM state
   ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT MAX park_name, area
   FROM park;
   WHERE area = (SELECT max (area) FROM park); --subquery
   


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
   FROM city
   ORDER BY population DESC
   LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established
   FROM park
   ORDER BY park_name, date_established
   LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ', ' || state_abbreviation AS city_state
   FROM city;

-- The all parks by name and date established.
SELECT park_name || ': ' || date_established AS park_founding
   FROM park;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ': ' ||state_name
   FROM state
   WHERE census_region IN ('West', 'Midwest')
   ORDER BY census_region, state_name;
   


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT ROUND(AVG(population), 2) AS average_population_of_all_states
   FROM state;


-- Total population in the West and South census regions
SELECT SUM(population) AS total_population_west_south
   FROM state
   WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT (population) AS cities_with_pop_larger_than_1mill
   FROM city
   WHERE population > 1000000;
   
   
-- The number of state nicknames.
SELECT COUNT(state_nickname)
   FROM state;
   


-- The area of the smallest and largest parks.
SELECT park_name, area
   FROM park
   WHERE area = (SELECT MIN(area) FROM park) OR area = (SELECT MAX(area) FROM park); 


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS cities,
    (SELECT state_name
  		FROM state
	 	WHERE state_abbreviation = c.state_abbreviation
	 )
   FROM city c
   GROUP BY c.state_abbreviation
   ORDER BY cities DESC;
   

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT park_name, ROUND(AVG(area), 2) AS average_area
   FROM park
   WHERE has_camping = true
   GROUP BY park_name, has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT SUM(population) AS all_cities_population,
    (SELECT state_name
	    FROM state
	    WHERE state_abbreviation = c.state_abbreviation
	)
	FROM city c
	GROUP by c.state_abbreviation
	ORDER BY all_cities_population DESC;


-- The smallest city population in each state ordered by city population.
SELECT MIN(population) AS all_cities_population,
    (SELECT state_name
	    FROM state
	    WHERE state_abbreviation = c.state_abbreviation
	)
	FROM city c
	GROUP by c.state_abbreviation
	ORDER BY all_cities_population;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

