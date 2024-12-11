package ru.menshikova.oom_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.menshikova.oom_2.entity.Author;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}