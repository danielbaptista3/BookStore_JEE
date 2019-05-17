package com.esgi.bookstore.book.repository;

import com.esgi.bookstore.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@Repository
public class BookRepository extends JpaRepository<Book, String> {

    @Query("select * from Book")
    public List<Book> findAll();

    @Query("select * from Book where id = :id")
    public List<Book> findByID(@Param("id") Integer id);

}
