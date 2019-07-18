package com.esgi.bookstore.model;

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
    private int price;
}
