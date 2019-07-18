package com.esgi.bookstore.controller;

import com.esgi.bookstore.model.Manga;
import com.esgi.bookstore.service.MangaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MangaController {

    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @RequestMapping("/mangas")
    public List<Manga> getAllMangas() {
        return mangaService.getAllMangas();
    }

    @RequestMapping(value = "/mangas/{id}", method = RequestMethod.GET)
    public List<Manga> getMangasByID(@PathVariable Integer id) {
        return mangaService.getMangasByID(id);
    }
}
