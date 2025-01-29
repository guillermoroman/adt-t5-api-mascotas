package com.example.adt_t5_api_1b.controllers;

import com.example.adt_t5_api_1b.model.Author;
import com.example.adt_t5_api_1b.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthorController {


    private AuthorService service;


    public AuthorController(AuthorService service) {
        this.service = service;
    }

    // POST http://localhost:8080/authors
    @PostMapping("authors")
    public ResponseEntity<Author> create(@RequestBody Author author){
        this.service.save(author);

        return ResponseEntity.ok(author);
    }
;



}
