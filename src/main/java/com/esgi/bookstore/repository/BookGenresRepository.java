package com.esgi.bookstore.repository;

import com.esgi.bookstore.model.BookGenres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenresRepository extends JpaRepository<BookGenres, Long> {

}