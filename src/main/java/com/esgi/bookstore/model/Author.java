package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Author {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private  String name;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
