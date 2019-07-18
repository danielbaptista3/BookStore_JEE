package com.esgi.bookstore.repository;

import com.esgi.bookstore.model.Manga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, String> {

    @Query("select * from Manga")
    public List<Manga> findAll();

    @Query("select * from Manga where id = :id")
    public List<Manga> findByID(@Param("id") Integer id);

}
