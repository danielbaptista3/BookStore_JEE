package com.esgi.bookstore.manga.services;

import com.esgi.bookstore.manga.model.Manga;
import com.esgi.bookstore.manga.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MangaService {

    private final MangaRepository mangaRepository;

    @Autowired
    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Transactional
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    @Transactional
    public List<Manga> getMangasByID(Integer mangaID) {
        return mangaRepository.findAll(mangaID);
    }
}
