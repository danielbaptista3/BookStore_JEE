package com.esgi.bookstore.comic.controller;

import com.esgi.bookstore.comic.model.Book;
import com.esgi.bookstore.comic.services.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/comics")
    public List<Book> getAllComics() {
        return bookService.getAllComics();
    }

    @RequestMapping(value="/comics/{id}", method= RequestMethod.GET)
    public List<Book> getComicsByID(@PathVariable Integer id) {
        return bookService.getComicsByID(id);
    }
}
