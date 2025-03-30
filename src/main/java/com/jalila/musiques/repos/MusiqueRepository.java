package com.jalila.musiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalila.musiques.entities.Musique;

public interface MusiqueRepository extends JpaRepository<Musique, Long> {

}
