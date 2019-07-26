package com.esgi.bookstore.controller;

import com.esgi.bookstore.assembler.PublisherResourceAssembler;
import com.esgi.bookstore.exception.NotFoundException;
import com.esgi.bookstore.model.Publisher;
import com.esgi.bookstore.repository.PublisherRepository;
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
public class PublisherController {

    @Autowired
    private final PublisherRepository repository;

    private final PublisherResourceAssembler assembler;

    PublisherController(PublisherRepository repository,
                        PublisherResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    // GET ALL
    @GetMapping("/publishers")
    public Resources<Resource<Publisher>> all() {

        List<Resource<Publisher>> publishers = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(publishers,
                linkTo(methodOn(PublisherController.class).all()).withSelfRel());
    }

    // ADD BOOK
    @PostMapping("/publishers")
    public ResponseEntity<?> newPublisher(@RequestBody Publisher newPublisher) throws URISyntaxException {

        Resource<Publisher> resource = assembler.toResource(repository.save(newPublisher));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // GET BY ID
    @GetMapping("/publishers/{id}")
    public Resource<Publisher> one(@PathVariable Long id) {

        Publisher publisher = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Publisher", id));

        return assembler.toResource(publisher);
    }

    // UPDATE BY ID
    @PutMapping("/publishers/{id}")
    public ResponseEntity<?> replacePublisher(@RequestBody Publisher newPublisher, @PathVariable Long id) throws URISyntaxException {

        Publisher updatedPublisher = repository.findById(id)
                .map(publisher -> {
                    publisher.setName(newPublisher.getName());
                    publisher.setBooks(newPublisher.getBooks());
                    return repository.save(publisher);
                })
                .orElseGet(() -> {
                    newPublisher.setId(id);
                    return repository.save(newPublisher);
                });

        Resource<Publisher> resource = assembler.toResource(updatedPublisher);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    // DELETE BY ID
    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}