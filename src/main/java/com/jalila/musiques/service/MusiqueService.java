package com.jalila.musiques.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.jalila.musiques.entities.Musique;

public interface MusiqueService {
    Musique saveMusique(Musique m);
    Musique updateMusique(Musique m);
    void deleteMusique(Musique m);
    void deleteMusiqueById(Long id);
    Musique getMusique(Long id);
    List<Musique> getAllMusiques();
    Page<Musique> getAllMusiquesParPage(int page, int size);
}