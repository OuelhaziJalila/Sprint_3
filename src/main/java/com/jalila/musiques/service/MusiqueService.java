package com.jalila.musiques.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.jalila.musiques.MusiqueDTO;
import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;

public interface MusiqueService {
	MusiqueDTO saveMusique(MusiqueDTO m);
    MusiqueDTO getMusique(Long id);
    List<MusiqueDTO> getAllMusiques();
    
    MusiqueDTO updateMusique(MusiqueDTO m);
    void deleteMusique(Musique m);
    void deleteMusiqueById(Long id);
   
    List<Musique> findByTitre(String titre);
    List<Musique> findByTitreContains(String titre);
    List<Musique> findByTitrePopularite(String titre, Double popularite);
    
    List<Musique> findByGenre(Genre genre);
    List<Musique> findByGenreIdGenre(Long id);
    
    List<Musique> findByOrderByTitreAsc();
    List<Musique> trierMusiquesTitrePopularite();

    Page<Musique> getAllMusiquesParPage(int page, int size);
    
    List<Genre> getAllGenres();
    MusiqueDTO convertEntityToDto (Musique musique);
    Musique convertDtoToEntity(MusiqueDTO musiqueDto);

}
