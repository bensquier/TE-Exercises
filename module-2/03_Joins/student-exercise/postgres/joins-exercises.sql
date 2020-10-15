 -- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT f.title AS films_starring_Nick_Stallone
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE';

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

SELECT f.title AS films_starring_Rita_Reynolds
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
WHERE a.first_name = 'RITA' AND a.last_name = 'REYNOLDS';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT f.title AS films_starring_Judy_Dean_or_River_Dean
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
WHERE  a.last_name = 'DEAN';

-- 4. All of the the ‘Documentary’ films
-- (68 rows)

SELECT f.title AS documentary_films
FROM category c
        INNER JOIN film_category fc
                ON c.category_id = fc.category_id
                        INNER JOIN film f
                                ON fc.film_id = f.film_id
WHERE  c.name = 'Documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)

SELECT f.title AS comedy_films
FROM category c
        INNER JOIN film_category fc
                ON c.category_id = fc.category_id
                        INNER JOIN film f
                                ON fc.film_id = f.film_id
WHERE  c.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

SELECT f.title AS G_rated_childrens_films
FROM category c
        INNER JOIN film_category fc
                ON c.category_id = fc.category_id
                        INNER JOIN film f
                                ON fc.film_id = f.film_id
WHERE  c.name = 'Children' AND f.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT f.title AS G_rated_childrens_films
FROM category c
        INNER JOIN film_category fc
                ON c.category_id = fc.category_id
                        INNER JOIN film f
                                ON fc.film_id = f.film_id
WHERE  c.name = 'Family' AND f.rating = 'G' AND f.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

SELECT f.title AS films_starring_Mathew_Leigh
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
                                        INNER JOIN film_category fc
                                                ON f.film_id = fc.film_id
                                                        INNER JOIN category c
                                                                ON fc.category_id = c.category_id
WHERE a.first_name = 'MATTHEW' AND a.last_name = 'LEIGH' AND f.rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT *
FROM category c
        INNER  JOIN film_category fc
                ON c.category_id = fc.category_id
                        INNER JOIN film f
                                ON fc.film_id = f.film_id
WHERE c.name = 'Sci-Fi' AND f.release_year = '2006';

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

SELECT f.title AS films_starring_Nick_Stallone
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
                                        INNER JOIN film_category fc
                                                ON f.film_id = fc.film_id
                                                        INNER JOIN category c
                                                                ON fc.category_id = c.category_id
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE' AND c.name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT a.address AS street_address, cty.city AS city, a.district AS district, c.country AS country
FROM country c
        INNER JOIN city cty
                ON c.country_id = cty.country_id
                        INNER JOIN address a
                                ON cty.city_id = a.city_id
                                        INNER JOIN store s
                                                ON a.address_id = s.address_id;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

SELECT s.store_id, a.address, stf.first_name || ' ' || stf.last_name AS manager
FROM country c
        INNER JOIN city cty
                ON c.country_id = cty.country_id
                        INNER JOIN address a
                                ON cty.city_id = a.city_id
                                        INNER JOIN store s
                                                ON a.address_id = s.address_id
                                                        INNER JOIN staff stf
                                                                ON s.manager_staff_id = stf.staff_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)

SELECT c.first_name, c.last_name, COUNT(c.customer_id) AS number_of_rentals
FROM customer c
        INNER JOIN rental r
                ON c.customer_id = r.customer_id
GROUP BY  c.customer_id, c.first_name, c.last_name
ORDER BY COUNT(c.customer_id) DESC
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)

SELECT c.first_name || ' ' || c.last_name AS name, SUM(p.amount)
FROM payment p
        LEFT JOIN customer c
                ON c.customer_id = p.customer_id
GROUP BY c.customer_id
ORDER BY SUM(p.amount) DESC
LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT s.store_id AS store_id, a.address, COUNT(r.rental_id), SUM(amount),  SUM(amount) / COUNT(r.rental_id)  AS average_sale
FROM address a
        INNER JOIN store s
                ON a.address_id = s.address_id
                        INNER JOIN inventory inv
                                ON s.store_id = inv.store_id
                                        LEFT JOIN rental r
                                                ON inv.inventory_id = r.inventory_id
                                                        LEFT JOIN payment p
                                                                ON r.rental_id = p.rental_id
GROUP BY s.store_id, a.address
ORDER BY s.store_id;
                                                                

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)

SELECT f.title, COUNT(inv.film_id) AS times_rented
FROM film f
        LEFT JOIN inventory inv
                ON f.film_id = inv.film_id
                        LEFT JOIN rental r
                                ON inv.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY COUNT(inv.film_id) DESC
LIMIT 10;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)

SELECT c.name AS category, COUNT(inv.film_id) AS times_rented
FROM film f
        INNER JOIN film_category fc
                ON f.film_id = fc.film_id
                        INNER JOIN category c
                                ON fc.category_id = c.category_id
                                        LEFT JOIN inventory inv
                                                ON f.film_id = inv.film_id
                                                        LEFT JOIN rental r
                                                                ON inv.inventory_id = r.inventory_id
                                        
GROUP BY c.name
ORDER BY COUNT(inv.film_id) DESC
LIMIT 5;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

SELECT f.title, COUNT(inv.film_id) AS times_rented
FROM film f
        INNER JOIN film_category fc
                ON f.film_id = fc.film_id
                        INNER JOIN category c
                                ON fc.category_id = c.category_id
                                        LEFT JOIN inventory inv
                                                ON f.film_id = inv.film_id
                                                        LEFT JOIN rental r
                                                                ON inv.inventory_id = r.inventory_id
WHERE c.name = 'Action'                                       
GROUP BY f.title
ORDER BY COUNT(inv.film_id) DESC
LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)

SELECT a.first_name || ' ' || a.last_name AS actor_name, COUNT(inv.film_id)
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
                                        LEFT JOIN inventory inv
                                                ON f.film_id = inv.film_id
                                                        LEFT JOIN rental r
                                                                ON inv.inventory_id = r.inventory_id
GROUP BY a.actor_id
ORDER BY COUNT(inv.film_id) DESC
LIMIT 10;


-- 20. The top 5 Comedy actors ranked by number of rentals of films in the Comedy category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)

SELECT a.first_name || ' ' || a.last_name AS actor_name, COUNT(inv.film_id) AS times_rented
FROM actor a
        INNER JOIN film_actor fa
                ON a.actor_id = fa.actor_id
                        INNER JOIN film f
                                ON fa.film_id = f.film_id
                                        INNER JOIN film_category fc
                                                ON f.film_id = fc.film_id
                                                        INNER JOIN category c
                                                                ON fc.category_id = c.category_id
                                                                        LEFT JOIN inventory inv
                                                                                ON f.film_id = inv.film_id
                                                                                        LEFT JOIN rental r
                                                                                                ON inv.inventory_id = r.inventory_id
WHERE c.name = 'Comedy'                                       
GROUP BY a.actor_id
ORDER BY COUNT(inv.film_id) DESC
LIMIT 5;

