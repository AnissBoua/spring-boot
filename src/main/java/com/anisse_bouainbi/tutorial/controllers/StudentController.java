package com.anisse_bouainbi.tutorial.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.anisse_bouainbi.tutorial.models.Student;
import com.anisse_bouainbi.tutorial.services.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(final StudentService service) {
        this.service = service;
    } 

    @GetMapping("/")
	public List<Student> getAll() {
		return service.getStudents();
	}

    @PostMapping("/")
	public Student create(@RequestBody Student student) {
		return service.create(student);
	}

    @PutMapping("/{id}")
	public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        System.out.println("ID: " + id);
        System.out.println("Data: " + student);
		return service.update(id, student);
	}

    @DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
