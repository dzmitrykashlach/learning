/*CREATE OR REPLACE FUNCTION gen_random_string(_min_length INT = 3)
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

CREATE TABLE IF NOT exists huge_table_with_uuid (
id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
column1 VARCHAR(255) NOT NULL,
column2 VARCHAR(255) NOT NULL,
column3 TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
*/

DO
$do$
BEGIN
FOR index IN 1..10000000 LOOP
INSERT INTO huge_table_with_uuid (column1,column2)
SELECT gen_random_string(),
gen_random_string();
END LOOP;
END
$do$;