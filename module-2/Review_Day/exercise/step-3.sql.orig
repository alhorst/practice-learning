-- CAMPGROUND TABLE
-----------------------------------------------

-- select name and daily fee of all campgrounds (expected: 7 rows)
SELECT campground.name, campground.daily_fee
   FROM campground;
-- select name and daily fee of all campgrounds ordered by campground name (expected: 7 rows, starting with "Blackwoods")
SELECT campground.name, campground.daily_fee
   FROM campground
   ORDER BY campground.name;
-- select name, open from month, open to month, and daily fee of the campgrounds where daily fee is less than $100 (expected: 5 rows)
SELECT campground.name, campground.open_from_mm, campground.open_to_mm, campground.daily_fee
   FROM campground
   WHERE campground.daily_fee < '100';
-- select name and daily fee of the campgrounds where the campground is open all year long (expected: 4 rows)
SELECT campground.name, campground.daily_fee
   FROM campground
   WHERE campground.open_from_mm = 1 AND campground.open_to_mm = 12;

-- PARK TABLE
-----------------------------------------------

-- select name and description of all parks order by established date in descending order (expected: 3 rows, startng with "Cuyahoga Valley")
SELECT park.name, park.description
   FROM park
   ORDER BY park.establish_date DESC;
-- select name and description of all parks in Ohio (expected: 1 row)
SELECT park.name, park.description
   FROM park
   WHERE location LIKE '%Ohio%';
-- select name and description of all parks NOT in Ohio (expected: 2 rows)
SELECT park.name, park.description
   FROM park
   WHERE location NOT LIKE '%Ohio%';
-- select the total number of visitors for all parks (expected: around 6 million)
SELECT SUM(park.visitors)
   FROM park;
-- select the average number of visitors for all parks (expected: around 2 million)
SELECT AVG(park.visitors)
   FROM park;

-- SITE TABLE
-----------------------------------------------

-- select all columns from site where utilities is true and order by max RV length with the largest coming first
-- (expected: 26 rows, starting with 35-foot max_rv_length)
SELECT * 
   FROM site
   WHERE site.utilities = 'true'
   ORDER BY site.max_rv_length DESC;
-- select total number of sites that have utilities hook up (expected: around 25)
SELECT COUNT(site.utilities)
   FROM site
   WHERE site.utilities = 'true';

-- RESERVATION TABLE
-----------------------------------------------

-- select reservation id, site id, name, from date, to date of the reservations where the checkin date 
--	is between the first and last day of the current month (hard coded month is ok) 
-- (expected row count may vary, should be no more than 44)
SELECT reservation_id, site_id, from_date, to_date
   FROM reservation
   WHERE from_date BETWEEN '11-01-2022' AND '11-30-2022';
-- select all columns from reservation where name includes 'Reservation' (expected: 23 rows)
SELECT *
   FROM reservation
   WHERE reservation.name LIKE '%Reservation%';
-- select the total number of reservations in the reservation table (expected: around 40)
SELECT COUNT(reservation_id) AS num_of_reservations
   FROM reservation;
-- select reservation id, site id, name of the reservations where site id is in the list 9, 20, 24, 45, 46 (expected: 16 rows)
SELECT reservation_id, site_id, reservation.name
   FROM reservation
   WHERE site_id = 9 OR site_id = 20 OR site_id = 24 OR site_id = 45 OR site_id = 46;
-- select the date and number of reservations for each date ordered by from_date in ascending order (expected: 24 rows, starting from the earliest date)
SELECT from_date, COUNT(reservation_id)
   FROM reservation
   GROUP BY from_date
   ORDER BY from_date;
