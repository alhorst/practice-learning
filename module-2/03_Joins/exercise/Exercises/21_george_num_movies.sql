-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)
SELECT person.person_name, COUNT(movie.title) AS num_of_movies
   FROM movie
   JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
   FULL OUTER JOIN person ON person.person_id = movie_actor.actor_id
   WHERE person.person_name LIKE 'George %'
   GROUP BY person.person_id
   ORDER BY person.person_name;

