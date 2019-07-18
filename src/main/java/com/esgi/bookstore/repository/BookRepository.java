package com.esgi.bookstore.repository;

import com.esgi.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("select * from Book")
    public List<Book> findAll();

    @Query("select * from Book where id = :id")
    public List<Book> findByID(@Param("id") Integer id);

}
