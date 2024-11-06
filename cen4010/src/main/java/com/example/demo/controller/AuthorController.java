package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        if (author.getFirstName() == null || author.getFirstName().isEmpty() ||
                author.getLastName() == null || author.getLastName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            authorService.addAuthor(author);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error creating author: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




