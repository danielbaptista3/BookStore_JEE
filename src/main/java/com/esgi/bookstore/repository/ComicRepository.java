package com.esgi.bookstore.repository;

import com.esgi.bookstore.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, String> {

    @Query("select * from Comic")
    public List<Comic> findAll();

    @Query("select * from Comic where id = :id")
    public List<Comic> findByID(@Param("id") Integer id);

}
