package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Book {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @ManyToOne
    private Author author;

    private Publisher publisher;

    private Date publishDate;

    private Integer price;

    private Type type;

    @OneToMany(mappedBy = "book")
    Set<BookGenres> bookGenres;
}
