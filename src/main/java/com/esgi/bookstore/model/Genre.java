package com.esgi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Genre {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private  String name;

    @OneToMany(mappedBy = "genres")
    Set<BookGenres> bookGenres;
}
