package com.anisse_bouainbi.tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.anisse_bouainbi.tutorial.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
