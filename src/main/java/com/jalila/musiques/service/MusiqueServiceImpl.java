package com.jalila.musiques.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jalila.musiques.MusiqueDTO;
import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.repos.MusiqueRepository;
import com.jalila.musiques.repos.GenreRepository;

@Service
public class MusiqueServiceImpl implements MusiqueService {

    @Autowired
    MusiqueRepository musiqueRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public MusiqueDTO saveMusique(MusiqueDTO m) {
        return convertEntityToDto(musiqueRepository.save(convertDtoToEntity(m)));
    }

    @Override
    public MusiqueDTO updateMusique(MusiqueDTO m) {
        return convertEntityToDto(musiqueRepository.save(convertDtoToEntity(m)));
    }

    @Override
    public void deleteMusique(Musique m) {
        musiqueRepository.delete(m);
    }

    @Override
    public void deleteMusiqueById(Long id) {
        musiqueRepository.deleteById(id);
    }

    @Override
    public MusiqueDTO getMusique(Long id) {
        return convertEntityToDto(musiqueRepository.findById(id).get());
    }

    @Override
    public List<MusiqueDTO> getAllMusiques() {
       return musiqueRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    	/*List<Musique> musiques = musiqueRepository.findAll();
    	List<MusiqueDTO> listMusiqueDto = new ArrayList<>(musiques.size());
    	for (Musique m : musiques)
    	    listMusiqueDto.add(convertEntityToDto(m));
    	return listMusiqueDto;*/
    	
    }

    @Override
    public Page<Musique> getAllMusiquesParPage(int page, int size) {
        return musiqueRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Musique> findByTitre(String titre) {
        return musiqueRepository.findByTitre(titre);
    }

    @Override
    public List<Musique> findByTitreContains(String titre) {
        return musiqueRepository.findByTitreContains(titre);
    }

    @Override
    public List<Musique> findByTitrePopularite(String titre, Double popularite) {
        return musiqueRepository.findByTitrePopularite(titre, popularite);
    }

    @Override
    public List<Musique> findByGenre(Genre genre) {
        return musiqueRepository.findByGenre(genre);
    }

    @Override
    public List<Musique> findByGenreIdGenre(Long id) {
        return musiqueRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Musique> findByOrderByTitreAsc() {
        return musiqueRepository.findByOrderByTitreAsc();
    }

    @Override
    public List<Musique> trierMusiquesTitrePopularite() {
        return musiqueRepository.trierMusiquesTitrePopularite();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

	@Override
	public MusiqueDTO convertEntityToDto(Musique musique) {
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		 MusiqueDTO musiqueDTO = modelMapper.map(musique, MusiqueDTO.class);
		    return musiqueDTO;
		
		
		/* MusiqueDTO musiqueDTO = new MusiqueDTO();
		    musiqueDTO.setIdMusique(musique.getIdMusique());
		    musiqueDTO.setTitre(musique.getTitre());
		    musiqueDTO.setArtiste(musique.getArtiste());
		    musiqueDTO.setDateSortie(musique.getDateSortie());
		    musiqueDTO.setPopularite(musique.getPopularite());
		    musiqueDTO.setGenre(musique.getGenre());
		    return musiqueDTO;*/
		/*return MusiqueDTO.builder()
	            .idMusique(musique.getIdMusique())
	            .titre(musique.getTitre())
	            .artiste(musique.getArtiste())
	            .dateSortie(musique.getDateSortie())
	           // .popularite(musique.getPopularite())
	            //.nomGenre(musique.getGenre().getNomGenre())
	            .genre(musique.getGenre())
	            .build();*/
	}

	@Override
	public Musique convertDtoToEntity(MusiqueDTO musiqueDto) {
		Musique musique = new Musique();
	    musique = modelMapper.map(musiqueDto, Musique.class);
	    return musique;

		/* Musique musique = new Musique();
		    musique.setIdMusique(musiqueDto.getIdMusique());
		    musique.setTitre(musiqueDto.getTitre());
		    musique.setArtiste(musiqueDto.getArtiste());
		    musique.setDateSortie(musiqueDto.getDateSortie());
		    musique.setPopularite(musiqueDto.getPopularite());
		    musique.setGenre(musiqueDto.getGenre());
		    return musique;*/
	}
}
