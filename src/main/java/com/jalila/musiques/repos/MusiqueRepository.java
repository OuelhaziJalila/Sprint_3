package com.jalila.musiques.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.entities.Genre;

@RepositoryRestResource(path = "rest")
public interface MusiqueRepository extends JpaRepository<Musique, Long> {
    List<Musique> findByTitre(String titre);
    
    List<Musique> findByTitreContains(String titre);
    
    //@Query("select m from Musique m where m.titre like %?1 and m.popularite > ?2")
    //List<Musique> findByTitrePopularite (String titre, Double popularite);
    
    @Query("select m from Musique m where m.titre like %:titre and m.popularite > :popularite")
    List<Musique> findByTitrePopularite (@Param("titre") String titre, @Param("popularite") Double popularite);
    
    @Query("select m from Musique m where m.genre = ?1")
    List<Musique> findByGenre (Genre genre);
    
    List<Musique> findByGenreIdGenre(Long id);
    
    List<Musique> findByOrderByTitreAsc();
    
    @Query("select m from Musique m order by m.titre ASC, m.popularite DESC")
    List<Musique> trierMusiquesTitrePopularite ();
}