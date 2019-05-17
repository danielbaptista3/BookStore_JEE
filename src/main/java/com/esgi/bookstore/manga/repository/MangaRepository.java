package com.esgi.bookstore.manga.repository;

import com.esgi.bookstore.manga.model.Manga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MangaRepository extends JpaRepository<Manga, String> {

    @Query("select * from Book")
    public List<Manga> findAll();

    @Query("select * from Book where id = :id")
    public List<Manga> findByID(@Param("id") Integer id);

}
