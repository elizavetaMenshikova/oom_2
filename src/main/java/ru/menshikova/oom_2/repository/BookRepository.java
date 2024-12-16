package ru.menshikova.oom_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.menshikova.oom_2.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}