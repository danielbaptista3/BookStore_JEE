package com.esgi.bookstore.service;

import com.esgi.bookstore.model.Comic;
import com.esgi.bookstore.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ComicService {

    private final ComicRepository comicRepository;

    @Autowired
    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Transactional
    public List<Comic> getAllComics() {
        return comicRepository.findAll();
    }

    @Transactional
    public List<Comic> getComicsByID(Integer comicID) {
        return comicRepository.findByID(comicID);
    }
}
