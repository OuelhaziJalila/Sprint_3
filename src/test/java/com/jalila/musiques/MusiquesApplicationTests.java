package com.jalila.musiques;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.repos.MusiqueRepository;
import com.jalila.musiques.service.MusiqueService;

@SpringBootTest
class MusiquesApplicationTests {
    @Autowired
    private MusiqueRepository musiqueRepository;
    
    @Autowired
    private MusiqueService musiqueService;
    
    @Test
    public void testCreateMusique() {
        Musique musique = new Musique("Bohemian Rhapsody", "Queen", new Date(), 9.8);
        musiqueRepository.save(musique);
    }
    
    @Test
    public void testFindMusique() {
        Musique m = musiqueRepository.findById(1L).get();
        System.out.println(m);
    }
    
    @Test
    public void testUpdateMusique() {
        Musique m = musiqueRepository.findById(1L).get();
        m.setPopularite(10.0);
        musiqueRepository.save(m);
        System.out.println(m);
    }
    
    @Test
    public void testDeleteMusique() {
        musiqueRepository.deleteById(1L);
    }
    
    @Test
    public void testFindAllMusiques() {
        List<Musique> musiques = musiqueRepository.findAll();
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }
    
    @Test
    public void testGetAllMusiquesParPage() {
        Page<Musique> musiques = musiqueService.getAllMusiquesParPage(0, 2);
        System.out.println(musiques.getSize());
        System.out.println(musiques.getTotalElements());
        System.out.println(musiques.getTotalPages());
        musiques.getContent().forEach(m -> {
            System.out.println(m.toString());
        });
    }
    
    @Test
    public void testFindMusiqueByTitre() {
        List<Musique> musiques = musiqueRepository.findByTitre("Hotel California");
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testFindMusiqueByTitreContains() {
        List<Musique> musiques = musiqueRepository.findByTitreContains("You");
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testFindByTitrePopularite() {
        List<Musique> musiques = musiqueRepository.findByTitrePopularite("Lose Yourself", 7.5);
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testFindByGenre() {
        Genre genre = new Genre();
        genre.setIdGenre(1L);
        List<Musique> musiques = musiqueRepository.findByGenre(genre);
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testFindByGenreIdGenre() {
        List<Musique> musiques = musiqueRepository.findByGenreIdGenre(2L);
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testFindByOrderByTitreAsc() {
        List<Musique> musiques = musiqueRepository.findByOrderByTitreAsc();
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }

    @Test
    public void testTrierMusiquesTitrePopularite() {
        List<Musique> musiques = musiqueRepository.trierMusiquesTitrePopularite();
        for (Musique m : musiques) {
            System.out.println(m);
        }
    }
}