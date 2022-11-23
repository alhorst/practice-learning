-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city.city_name, state.state_abbreviation
   FROM state
   JOIN city ON city.state_abbreviation = state.state_abbreviation
   WHERE city.city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city.city_name, state.state_name
   FROM state
   JOIN city ON city.state_abbreviation = state.state_abbreviation
   WHERE city.city_name = 'Columbus';


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park.park_name, park_state.state_abbreviation
   FROM park_state
   JOIN park ON park.park_id = park_state.park_id; --convention to do JOIN park ON park_state.park_id = park.park_id
   
-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park.park_name, state.state_name
   FROM park_state
   JOIN park ON park.park_id = park_state.park_id
   JOIN state ON state.state_abbreviation = park_state.state_abbreviation;
   
SELECT p.park_name, s.state_name
   FROM state s
   JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
   JOIN park p ON ps.park_id = p.park_id;
  
-- Modify the previous query to include the name of the state's capital city.
SELECT p.park_name, s.state_name, s.capital AS state_capital
   FROM park_state
   JOIN park ON park.park_id = park_state.park_id
   JOIN state ON state.state_abbreviation = park_state.state_abbreviation
   JOIN city ON state.state_abbreviation = city.state_abbreviation
   GROUP BY state.capital, city.city_id;
   
SELECT p.park_name, s.state_name, c.city_name
   FROM state s
   JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
   JOIN park p ON ps.park_id = p.park_id
   JOIN city c ON s.capital = c.city_id;
   
-- Modify the previous query to include the area of each park.
SELECT p.park_name, p.area, s.state_name, c.city_name
   FROM state s
   JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
   JOIN park p ON ps.park_id = p.park_id
   JOIN city c ON s.capital = c.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, c.population
   FROM city c
   JOIN state s ON c.state_abbreviation = s.state_abbreviation
   WHERE census_region = 'Midwest';
   
-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT s.state_name, COUNT(city_name) AS cities_in_midwest
   FROM city c
   JOIN state s ON c.state_abbreviation = s.state_abbreviation
   WHERE census_region = 'Midwest'
   GROUP BY s.state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT s.state_name, COUNT(city_name) AS cities_in_midwest
   FROM city c
   JOIN state s ON c.state_abbreviation = s.state_abbreviation
   WHERE census_region = 'Midwest'
   GROUP BY s.state_name
   ORDER BY cities_in_midwest DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT s.state_name, MIN(p.date_established) AS oldest_park_in_state
   FROM state s
   JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
   JOIN park p ON ps.park_id = p.park_id
   GROUP BY s.state_name;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT s.state_name, MIN(p.date_established) AS oldest_park_in_state
   FROM state s
   LEFT JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
   LEFT JOIN park p ON ps.park_id = p.park_id
   GROUP BY s.state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT c.city_name AS place_name
   FROM city c 
   WHERE c.city_name LIKE 'W%'
UNION
SELECT s.state_name AS place_name
   FROM state s 
   WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT c.city_name AS place_name, 'City' AS kind_of_place
   FROM city c
   WHERE city_name LIKE 'W%'
UNION
SELECT s.state_name AS place_name, 'State' AS kind_of_place
   FROM state s
   WHERE s.state_name LIKE 'W%'
ORDER BY place_name;


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
   FROM genre;

-- The titles of all the Comedy movies
SELECT m.title
   FROM movie m
   JOIN movie_genre mg ON mg.movie = m.movie_id
   JOIN genre g on mg.genre_id
   WHERE g.genre_name = 'Comedy';
