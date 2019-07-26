package com.esgi.bookstore.controller;

import com.esgi.bookstore.assembler.AuthorResourceAssembler;
import com.esgi.bookstore.exception.NotFoundException;
import com.esgi.bookstore.model.Author;
import com.esgi.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class AuthorController {

    private final AuthorRepository repository;

    private final AuthorResourceAssembler assembler;

    @Autowired
    public AuthorController(AuthorRepository repository,
                            AuthorResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    // GET ALL
    @GetMapping("/authors")
    public Resources<Resource<Author>> all() {

        List<Resource<Author>> authors = repository.findAll().stream()
                .map((Author employee) -> assembler.toResource(employee))
                .collect(Collectors.toList());

        return new Resources<>(authors,
                linkTo(methodOn(AuthorController.class).all()).withSelfRel());
    }

    // ADD BOOK
    @PostMapping("/authors")
    public ResponseEntity<?> newAuthor(@RequestBody Author newAuthor) throws URISyntaxException {

        Resource<Author> resource = assembler.toResource(repository.save(newAuthor));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // GET BY ID
    @GetMapping("/authors/{id}")
    public Resource<Author> one(@PathVariable Long id) {

        Author author = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author", id));

        return assembler.toResource(author);
    }

    // UPDATE BY ID
    @PutMapping("/authors/{id}")
    public ResponseEntity<?> replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id) throws URISyntaxException {

        Author updatedAuthor = repository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setBooks(newAuthor.getBooks());
                    return repository.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setId(id);
                    return repository.save(newAuthor);
                });

        Resource<Author> resource = assembler.toResource(updatedAuthor);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // DELETE BY ID
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}