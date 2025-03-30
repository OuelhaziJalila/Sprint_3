package com.jalila.musiques;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.service.MusiqueService;

@SpringBootApplication
public class MusiquesApplication implements CommandLineRunner {
    @Autowired
    MusiqueService musiqueService;

    public static void main(String[] args) {
        SpringApplication.run(MusiquesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        musiqueService.saveMusique(new Musique("Despacito", "Luis Fonsi ft. Daddy Yankee", new Date(), 8.6));
        musiqueService.saveMusique(new Musique("Shape of You", "Ed Sheeran", new Date(), 8.5));
        musiqueService.saveMusique(new Musique("Blinding Lights", "The Weeknd", new Date(), 9.2));
    }
}