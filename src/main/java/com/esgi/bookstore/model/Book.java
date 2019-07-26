package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    private Date publishDate;

    private Integer price;

    private Type type;

    @OneToMany(mappedBy = "book")
    Set<BookGenres> bookGenres;
}
