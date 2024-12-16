package ru.menshikova.oom_2.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void findPageOOM() {
        assertThrows(OutOfMemoryError.class, () -> {
            int pageNumber = 0;
            int pageSize = 10;
            authorRepository.findPage(PageRequest.of(pageNumber, pageSize));
        });
    }
}