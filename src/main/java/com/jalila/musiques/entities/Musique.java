package com.jalila.musiques.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Musique {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusique;

    @NotNull
    @Size(min = 4, max = 100)
    private String titre;

    @NotNull
    @Size(min = 4, max = 50)
    private String artiste;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateSortie;

    @Min(value = 0)
    @Max(value = 100)
    private double popularite;

    @ManyToOne
    private Genre genre;

    public Musique() {
        super();
    }

    public Musique(String titre, String artiste, Date dateSortie, double popularite) {
        super();
        this.titre = titre;
        this.artiste = artiste;
        this.dateSortie = dateSortie;
        this.popularite = popularite;
    }

    public Long getIdMusique() {
        return idMusique;
    }

    public void setIdMusique(Long idMusique) {
        this.idMusique = idMusique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public double getPopularite() {
        return popularite;
    }

    public void setPopularite(double popularite) {
        this.popularite = popularite;
    }

    @Override
    public String toString() {
        return "Musique [idMusique=" + idMusique + ", titre=" + titre + ", artiste=" + artiste 
               + ", dateSortie=" + dateSortie + ", popularite=" + popularite + "]";
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

	
}
