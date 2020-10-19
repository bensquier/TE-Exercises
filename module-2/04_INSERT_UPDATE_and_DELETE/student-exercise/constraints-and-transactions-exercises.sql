-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

BEGIN TRANSACTION; 

INSERT INTO actor (first_name, last_name) VALUES ('Hampton', 'Avenue'),('Lisa', 'Byway')

RETURNING *;

COMMIT;

ROLLBACK;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

BEGIN TRANSACTION; 

INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 7, 4.99, 198, 29.99, 'G')

RETURNING *;

COMMIT;

ROLLBACK;
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

BEGIN TRANSACTION; 

INSERT INTO 
        film_actor(actor_id, film_id)
VALUES
        ((SELECT actor_id FROM actor WHERE first_name = 'Hampton' AND last_name = 'Avenue'), (SELECT film_id FROM film WHERE title = 'Euclidean PI')),
        ((SELECT actor_id FROM actor WHERE first_name = 'Lisa' AND last_name = 'Byway'), (SELECT film_id FROM film WHERE title = 'Euclidean PI'))

RETURNING *;

COMMIT;

ROLLBACK;

--SELECT * from film_actor;

-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION; 

INSERT INTO category (name) VALUES ('Mathmagical')

RETURNING *;

COMMIT;

ROLLBACK;
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

BEGIN TRANSACTION;

INSERT INTO 
        film_category(film_id,category_id)
VALUES 
        ((SELECT film_id FROM film WHERE  title = 'Euclidean PI'),(SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE  title = 'EGG IGBY'),(SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE  title = 'KARATE MOON'),(SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE  title = 'RANDOM GO'),(SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE  title = 'YOUNG LANGUAGE'),(SELECT category_id FROM category WHERE name = 'Mathmagical'))

RETURNING *;

COMMIT;

ROLLBACK;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;

UPDATE 
        film 
SET 
        rating = 'G'
WHERE 
        film_id IN
                (SELECT film_id FROM film_category WHERE category_id =
                (SELECT category_id FROM category WHERE name = 'Mathmagical'))
RETURNING *;

COMMIT;

ROLLBACK;

-- 7. Add a copy of "Euclidean PI" to all the stores.

BEGIN TRANSACTION; 

INSERT INTO 
        inventory(film_id,store_id)
VALUES
        ((SELECT film_id FROM film WHERE title = 'Euclidean PI'),1),
        ((SELECT film_id FROM film WHERE title = 'Euclidean PI'),2)
        
RETURNING *;

COMMIT;

ROLLBACK;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
--<No it did not work because it violates foreign key cinstraint.>
BEGIN TRANSACTION; 

DELETE FROM film WHERE title = 'Euclidean PI'

RETURNING *;

COMMIT;

ROLLBACK;

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
--<No it did not work because it violates foreign key cinstraint.>

BEGIN TRANSACTION;

DELETE FROM category WHERE name = 'Mathmagical'

RETURNING *;

COMMIT;

ROLLBACK;

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <Yes it works because it was a primary key.>

BEGIN TRANSACTION; 

DELETE FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')

RETURNING *;

COMMIT;

ROLLBACK;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <The first delete works because its no longer being used by the foreign key in the film category table, the second delete fails for the same reason it is still being used by film_category
>

BEGIN TRANSACTION; 

DELETE FROM category WHERE name = 'Mathmagical'

DELETE FROM film WHERE title = 'Euclidean PI'

RETURNING *;

COMMIT;

ROLLBACK;

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
/*
 first we would have to delete the film reference from tables film_category and film_actor before deleting the film itself.  
 This is because film_id is a primary key in these two tables.*/
 