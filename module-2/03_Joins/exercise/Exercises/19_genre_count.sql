-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).
SELECT genre.genre_name, COUNT (movie.title) AS num_of_movies
   FROM genre
   JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
   JOIN movie ON movie.movie_id = movie_genre.movie_id
   GROUP BY genre.genre_name
   ORDER BY COUNT (genre.genre_name) DESC;
