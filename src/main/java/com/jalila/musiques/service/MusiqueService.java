package com.jalila.musiques.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;

public interface MusiqueService {

    Musique saveMusique(Musique m);
    Musique updateMusique(Musique m);
    void deleteMusique(Musique m);
    void deleteMusiqueById(Long id);
    Musique getMusique(Long id);
    List<Musique> getAllMusiques();
    
    List<Musique> findByTitre(String titre);
    List<Musique> findByTitreContains(String titre);
    List<Musique> findByTitrePopularite(String titre, Double popularite);
    
    List<Musique> findByGenre(Genre genre);
    List<Musique> findByGenreIdGenre(Long id);
    
    List<Musique> findByOrderByTitreAsc();
    List<Musique> trierMusiquesTitrePopularite();

    Page<Musique> getAllMusiquesParPage(int page, int size);
    
    List<Genre> getAllGenres();
}
