package ru.menshikova.oom_2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.menshikova.oom_2.entity.Author;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    @Query(value = """
            select a
            from Author a
            left join fetch a.books
            """)
    Page<Author> findPage(Pageable pageable);
}