package com.esgi.bookstore.controller;

import com.esgi.bookstore.assembler.BookResourceAssembler;
import com.esgi.bookstore.exception.NotFoundException;
import com.esgi.bookstore.model.Book;
import com.esgi.bookstore.repository.BookRepository;
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
public class BookController {

    @Autowired
    private final BookRepository repository;

    private final BookResourceAssembler assembler;

    public BookController(BookRepository repository,
                   BookResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    // GET ALL
    @GetMapping("/books")
    public Resources<Resource<Book>> all() {

        List<Resource<Book>> books = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

    // ADD BOOK
    @PostMapping("/books")
    public ResponseEntity<?> newBook(@RequestBody Book newBook) throws URISyntaxException {

        Resource<Book> resource = assembler.toResource(repository.save(newBook));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // GET BY ID
    @GetMapping("/books/{id}")
    public Resource<Book> one(@PathVariable Long id) {  

        Book book = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book", id));

        return assembler.toResource(book);
    }

    // UPDATE BY ID
    @PutMapping("/books/{id}")
    public ResponseEntity<?> replaceBook(@RequestBody Book newBook, @PathVariable Long id) throws URISyntaxException {

        Book updatedBook = repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    book.setPublisher(newBook.getPublisher());
                    book.setPublishDate(newBook.getPublishDate());
                    book.setPrice(newBook.getPrice());
                    book.setType(newBook.getType());
                    book.setBookGenres(newBook.getBookGenres());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });

        Resource<Book> resource = assembler.toResource(updatedBook);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // DELETE BY ID
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}