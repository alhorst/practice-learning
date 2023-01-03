-- Select all columns from posts that are published
SELECT *
FROM posts
WHERE published = 'true';
-- Select posted_by and body from comments that have a body and were created after Oct. 15, 2019
SELECT comments.posted_by, comments.body
FROM comments
WHERE comments.body IS NOT NULL AND created > '2019-10-15';
-- Select the name and published states from posts ordered by when they were created, earliest first
SELECT name, published 
FROM posts
ORDER BY created;
-- Select the created date and the count of all the comments created on that date
SELECT COUNT(id), created AS created_date
FROM comments
GROUP BY created;
-- Select the post name, comment posted_by and comment body for all posts created after Oct. 1st, 2019
SELECT name, comments.posted_by, comments.body
FROM posts
JOIN comments ON comments.id = posts.id
WHERE posts.created > '2019-10-01';
