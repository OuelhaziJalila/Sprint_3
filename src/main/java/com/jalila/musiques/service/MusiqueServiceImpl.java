package com.jalila.musiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.repos.MusiqueRepository;
import com.jalila.musiques.repos.GenreRepository;

@Service
public class MusiqueServiceImpl implements MusiqueService {

    @Autowired
    MusiqueRepository musiqueRepository;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public Musique saveMusique(Musique m) {
        return musiqueRepository.save(m);
    }

    @Override
    public Musique updateMusique(Musique m) {
        return musiqueRepository.save(m);
    }

    @Override
    public void deleteMusique(Musique m) {
        musiqueRepository.delete(m);
    }

    @Override
    public void deleteMusiqueById(Long id) {
        musiqueRepository.deleteById(id);
    }

    @Override
    public Musique getMusique(Long id) {
        return musiqueRepository.findById(id).get();
    }

    @Override
    public List<Musique> getAllMusiques() {
        return musiqueRepository.findAll();
    }

    @Override
    public Page<Musique> getAllMusiquesParPage(int page, int size) {
        return musiqueRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Musique> findByTitre(String titre) {
        return musiqueRepository.findByTitre(titre);
    }

    @Override
    public List<Musique> findByTitreContains(String titre) {
        return musiqueRepository.findByTitreContains(titre);
    }

    @Override
    public List<Musique> findByTitrePopularite(String titre, Double popularite) {
        return musiqueRepository.findByTitrePopularite(titre, popularite);
    }

    @Override
    public List<Musique> findByGenre(Genre genre) {
        return musiqueRepository.findByGenre(genre);
    }

    @Override
    public List<Musique> findByGenreIdGenre(Long id) {
        return musiqueRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Musique> findByOrderByTitreAsc() {
        return musiqueRepository.findByOrderByTitreAsc();
    }

    @Override
    public List<Musique> trierMusiquesTitrePopularite() {
        return musiqueRepository.trierMusiquesTitrePopularite();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
