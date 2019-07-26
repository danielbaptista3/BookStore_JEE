package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class BookGenres {
 
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
 
    @ManyToOne
    Book book;
 
    @ManyToOne

    Genre genre;
}