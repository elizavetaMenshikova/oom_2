CREATE OR REPLACE FUNCTION generate_author_and_book(author_count INT,
													 book_count INT)
            RETURNS void AS $$
DECLARE
v_id UUID;
BEGIN
    FOR v_id IN
        INSERT INTO author (author_id, firstname, surname, lastname)
        SELECT
            uuid_in(md5(random()::text || now()::text)::cstring),
            md5(random()::text),
            md5(random()::text),
            md5(random()::text)
        FROM generate_series(1, author_count)
        RETURNING author_id
    LOOP
        INSERT INTO book (book_id, name, author_id)
        SELECT
            uuid_in(md5(random()::text || now()::text)::cstring),
            md5(random()::text),
            v_id
		FROM generate_series(1, book_count);
    END LOOP;
END;
$$ LANGUAGE plpgsql;