package com.anisse_bouainbi.tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.anisse_bouainbi.tutorial.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
