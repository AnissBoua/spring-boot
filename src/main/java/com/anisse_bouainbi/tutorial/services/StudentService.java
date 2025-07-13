package com.anisse_bouainbi.tutorial.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.anisse_bouainbi.tutorial.models.Student;
import com.anisse_bouainbi.tutorial.repositories.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(final StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {
        return repo.findAll();
	}

    public Student create(Student student) {
        Optional<Student> res = repo.findStudentByEmail(student.getEmail());
        if (res.isPresent()) return res.get();

        student.setAge(Period.between(student.getDob(), LocalDate.now()).getYears());
        return repo.save(student);
    }

    public Student update(Long id, Student student) {
        Student existing = repo.findById(id)
            .orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));

        if (student.getName() != null) existing.setName(student.getName());
        if (student.getEmail() != null) existing.setEmail(student.getEmail());
        if (student.getDob() != null) {
            existing.setDob(student.getDob());
            existing.setAge(Period.between(student.getDob(), LocalDate.now()).getYears());
        }

        return repo.save(existing);
    }

    public void delete(Long id) {
        boolean exist = repo.existsById(id);
        if (!exist) {
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }

        repo.deleteById(id);
    }
}
