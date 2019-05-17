package com.esgi.bookstore.comic.model;

import lombok.*;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
public class Comic {

    private String name;
    private String publishDate;
    private String category;
    private String author;
}
