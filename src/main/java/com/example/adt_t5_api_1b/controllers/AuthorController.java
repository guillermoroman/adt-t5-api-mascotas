package com.example.adt_t5_api_1b.controllers;

import com.example.adt_t5_api_1b.model.Author;
import com.example.adt_t5_api_1b.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AuthorController {

    private AuthorService service;


    public AuthorController(AuthorService service) {
        this.service = service;
    }

    // POST http://localhost:8080/authors
    @PostMapping("authors")
    public ResponseEntity<Author> create(@RequestBody Author author){
        // Comprobaciones
        if (author.getId()!=null){
            return ResponseEntity.badRequest().build();
        }

        // Guardado
        this.service.save(author);

        // Respuesta
        return ResponseEntity.ok(author);
    }

    @GetMapping("authors")
    public ResponseEntity<List<Author>>findAll(){
        // Obtener autores
        List<Author> authors = this.service.findAll();

        //Comprobación de lista no vacía
        if (authors.isEmpty())
            return ResponseEntity.notFound().build();

        // Respuesta
        return ResponseEntity.ok(authors);
    }

    // GET localhost/api/authors/1
    @GetMapping("authors/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){

        return this.service.findById(id).
                map(ResponseEntity::ok).
                orElseGet(()->ResponseEntity.notFound().build());

    }

    // GET localhost/api/authors/year/1920
    @GetMapping("authors/year/{year}")
    public ResponseEntity<List<Author>> findAllByYear(@PathVariable int year){
        // Obtener autores
        List<Author> authors = this.service.findAllByBirthYear(year);

        // Comprobación de lista no vacía
        if (authors.isEmpty())
            return ResponseEntity.notFound().build();

        // Respuesta
        return ResponseEntity.ok(authors);
    }

    // DELETE lolcalhost/api/authors/1
    @DeleteMapping("authors/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id){
        // Borrar autor
        this.service.deleteById(id);

        // Respuesta sin contenido
        return ResponseEntity.noContent().build();
    }






}
