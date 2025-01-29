package com.example.adt_t5_api_1b.services;

import com.example.adt_t5_api_1b.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    // READ
    List<Author> findAll();
    List<Author> findAllByYear(Integer year);

    Optional<Author> findById(Long id);
    Optional<Author> findByName(String name);

    // CREATE
    Author save (Author author);

    // DELETE
    void deleteById(Long id);
    void deleteAll();

    // UPDATE

}
