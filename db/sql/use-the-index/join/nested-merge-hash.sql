CREATE SCHEMA IF NOT EXISTS "use-the-index";
CREATE OR REPLACE FUNCTION gen_random_string(_min_length INT = 3)
RETURNS VARCHAR
LANGUAGE SQL
AS '
SELECT substring(
md5(random()::TEXT),
0,
_min_length + floor(random() * 10 + 1)::INT
)
';

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE IF NOT exists posts (
id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
column1 VARCHAR(255) NOT NULL,
column2 VARCHAR(255) NOT NULL,
timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);


DO
$do$
BEGIN
FOR index IN 1..1000000 LOOP
INSERT INTO posts (column1,column2)
SELECT gen_random_string(),
gen_random_string();
END LOOP;
END
$do$;



CREATE TABLE IF NOT exists comments (
id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
postId UUID NOT null REFERENCES posts (id),
timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

DO
$do$
BEGIN
FOR index IN 1..100 LOOP
WITH posts (id) as 
(select ptwu.id from posts ptwu limit 5 )
INSERT INTO comments(postId)  
SELECT 
  id
FROM 
  posts;
END LOOP;
END
$do$;  

-- nested loops vs hash join vs merge join

-- nested loops 0.455 ms,  Index Only Scan
 explain analyze select p.id, c.id from posts p 
	inner join comments c on p.id = c.postid  order by c.postid;

-- https://www.postgresql.org/docs/current/runtime-config-query.html#RUNTIME-CONFIG-QUERY-ENABLE
SET enable_nestloop to off;
SET enable_mergejoin to off;
SET enable_hashjoin to off;

-- hash join - 193.028 ms, no Index Only Scan
explain analyze select p.id, c.id from posts p 
	inner join comments c on p.id = c.postid  order by c.postid;

-- merge join - 60.631 ms, no Index Only Scan
explain analyze select p.id, c.id from posts p 
	inner join comments c on p.id = c.postid  order by c.postid;

explain analyze CREATE MATERIALIZED VIEW "posts-comments-join" AS select posts.id from posts  
	inner join comments  on posts.id = comments.postid  order by comments.postid WITH DATA;

explain analyze select * from "posts-comments-join" pcj 

-- aggregate, group by
explain analyze select c.postid, count(c.postid) from posts p
	inner join comments c on p.id = c.postid  group by c.postid ;
