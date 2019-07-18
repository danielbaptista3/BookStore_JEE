package com.esgi.bookstore.controller;

import com.esgi.bookstore.model.Comic;
import com.esgi.bookstore.service.ComicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComicController {

    private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @RequestMapping("/comics")
    public List<Comic> getAllComics() {
        return comicService.getAllComics();
    }

    @RequestMapping(value = "/comics/{id}", method = RequestMethod.GET)
    public List<Comic> getComicsByID(@PathVariable Integer id) {
        return comicService.getComicsByID(id);
    }
}
