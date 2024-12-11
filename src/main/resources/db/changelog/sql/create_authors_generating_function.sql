CREATE OR REPLACE FUNCTION generate_author()
            RETURNS void AS $$
BEGIN
    INSERT INTO author (id, firstname, surname, lastname)
    SELECT
        uuid_in(md5(random()::text || now()::text)::cstring),
        md5(random()::text),
        md5(random()::text),
        md5(random()::text)
    FROM generate_series(1, 10000000) AS gs;
END;
$$ LANGUAGE plpgsql;