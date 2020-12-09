CREATE TABLE Towns (
                       id SERIAL UNIQUE NOT NULL,
                       code VARCHAR(10) NOT NULL, -- not unique
                       article TEXT,
                       name TEXT NOT NULL -- not unique
);
insert into towns (
    code, article, name
)
select
    left(md5(i::text), 10),
    md5(random()::text),
    md5(random()::text)
from generate_series(1, 1000000) s(i);


SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;



CREATE INDEX  idx_towns_name ON towns(name);

SELECT * FROM towns;

EXPLAIN ANALYSE
SELECT * FROM towns WHERE name = '69df43e5b95a5c3f49de6bb62ca22283';


EXPLAIN ANALYSE
SELECT * FROM towns WHERE article = '1b4ff7742a3ac9e91871080e2de28400';






