package com.jalila.musiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jalila.musiques.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
