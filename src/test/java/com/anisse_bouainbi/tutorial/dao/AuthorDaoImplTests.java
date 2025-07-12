package com.anisse_bouainbi.tutorial.dao;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anisse_bouainbi.tutorial.dao.impl.AuthorDaoImpl;
import com.anisse_bouainbi.tutorial.models.Author;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbc;

    @InjectMocks
    private AuthorDaoImpl dao;

    @Test
    public void test_author_correct_create_sql() {
        Author author = Author.builder()
            .id(1L)
            .name("Anisse")
            .age(1)
            .build();

        dao.create(author);

        verify(jdbc).update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)", 1L, "Anisse", 1);
    }
}
