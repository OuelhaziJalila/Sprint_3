package com.jalila.musiques.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jalila.musiques.MusiqueDTO;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.service.MusiqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MusiqueRESTController {
    @Autowired
    MusiqueService musiqueService;
    @RequestMapping(method = RequestMethod.GET)
    public List<MusiqueDTO> getAllMusiques() {
        return musiqueService.getAllMusiques();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public MusiqueDTO getMusiqueById(@PathVariable("id") Long id) {
        return musiqueService.getMusique(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public MusiqueDTO createMusique(@RequestBody MusiqueDTO musiqueDTO) {
        return musiqueService.saveMusique(musiqueDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public MusiqueDTO updateMusique(@RequestBody MusiqueDTO musiqueDTO) {
        return musiqueService.updateMusique(musiqueDTO);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteMusique(@PathVariable("id") Long id) {
        musiqueService.deleteMusiqueById(id);
    }

    @RequestMapping(value="/musiquesgenre/{idGenre}", method = RequestMethod.GET)
    public List<Musique> getMusiquesByGenreId(@PathVariable("idGenre") Long idGenre) {
        return musiqueService.findByGenreIdGenre(idGenre);
    }
}
