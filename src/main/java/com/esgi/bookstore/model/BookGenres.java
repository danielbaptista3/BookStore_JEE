package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
class BookGenres {
 
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
 
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
 
    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;
}