package com.esgi.bookstore.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "choices")
public class Manga {

    private String name;
    private String publishDate;
    private String category;
    private String author;
    private int price;
}
