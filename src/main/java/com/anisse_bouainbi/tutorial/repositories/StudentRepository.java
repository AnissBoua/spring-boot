package com.anisse_bouainbi.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.anisse_bouainbi.tutorial.models.Student;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s from Student s Where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
