package com.jalila.musiques;

import java.util.Date;

import com.jalila.musiques.entities.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusiqueDTO {
    private Long idMusique;
    private String titre;
    private String artiste;
    private Date dateSortie;
    private double popularite;
    private Genre genre;
    private String nomGenre;



}
