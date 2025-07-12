package com.anisse_bouainbi.tutorial.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.anisse_bouainbi.tutorial.models.Author;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthorController {

    @PostMapping("/authors")
    public Author create(@RequestBody Author entity) {
        return entity;
    }
}
