package com.esgi.bookstore.book.controller;

import com.esgi.bookstore.book.model.Book;
import com.esgi.bookstore.book.services.BookService;
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

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value="/books/{id}", method= RequestMethod.GET)
    public List<Book> getBooksByID(@PathVariable Integer id) {
        return bookService.getBooksByID(id);
    }
}
