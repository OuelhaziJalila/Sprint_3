package com.jalila.musiques;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.service.MusiqueService;

@SpringBootApplication
public class MusiquesApplication implements CommandLineRunner {

    @Autowired
    MusiqueService musiqueService;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MusiquesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Musique.class, Genre.class);
    }
}
