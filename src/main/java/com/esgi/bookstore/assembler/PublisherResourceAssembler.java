package com.esgi.bookstore.assembler;

import com.esgi.bookstore.controller.PublisherController;
import com.esgi.bookstore.model.Publisher;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PublisherResourceAssembler implements ResourceAssembler<Publisher, Resource<Publisher>> {

    @Override
    public Resource<Publisher> toResource(Publisher publisher) {

        return new Resource<>(publisher,
                linkTo(methodOn(PublisherController.class).one(publisher.getId())).withSelfRel(),
                linkTo(methodOn(PublisherController.class).all()).withRel("publishers"));
    }
}