package com.esgi.bookstore.manga.model;

import lombok.*;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
public class Manga {

    private String name;
    private String publishDate;
    private String category;
    private String author;
}
