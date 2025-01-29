package com.example.adt_t5_api_1b.controllers;

import com.example.adt_t5_api_1b.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthorController {

    @PostMapping("authors/")
    public ResponseEntity<Author> create()
}
