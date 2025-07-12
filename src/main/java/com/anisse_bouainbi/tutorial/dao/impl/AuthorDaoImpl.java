package com.anisse_bouainbi.tutorial.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.anisse_bouainbi.tutorial.dao.AuthorDAO;
import com.anisse_bouainbi.tutorial.models.Author;

public class AuthorDaoImpl implements AuthorDAO {
    private final JdbcTemplate jdbc;

    public AuthorDaoImpl(final JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void create(Author author) {
        jdbc.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)", author.getId(), author.getName(), author.getAge());
    }

}
