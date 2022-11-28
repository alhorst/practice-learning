-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
SELECT genre.genre_name
   FROM genre
   JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
   JOIN movie ON movie.movie_id = movie_genre.movie_id
   WHERE movie.title LIKE '%The Wizard of Oz%'
   ORDER BY genre.genre_name;
   

