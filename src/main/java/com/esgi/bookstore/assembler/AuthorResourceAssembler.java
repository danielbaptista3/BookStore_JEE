package com.esgi.bookstore.assembler;

import com.esgi.bookstore.controller.BookController;
import com.esgi.bookstore.model.Author;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AuthorResourceAssembler implements ResourceAssembler<Author, Resource<Author>> {

    @Override
    public Resource<Author> toResource(Author author) {

        return new Resource<>(author,
                linkTo(methodOn(BookController.class).one(author.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).all()).withRel("authors"));
    }
}