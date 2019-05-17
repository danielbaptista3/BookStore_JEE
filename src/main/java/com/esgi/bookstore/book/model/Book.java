package com.esgi.bookstore.book.model;

import lombok.*;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
public class Book {

    private String name;
    private String publishDate;
    private String category;
    private String author;
}
