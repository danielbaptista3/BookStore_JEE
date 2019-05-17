package com.esgi.bookstore.comic.services;

import com.esgi.bookstore.comic.model.Book;
import com.esgi.bookstore.comic.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<Book> getAllComics() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> getComicsByID(Integer comicID) {
        return bookRepository.findAll(comicID);
    }
}
