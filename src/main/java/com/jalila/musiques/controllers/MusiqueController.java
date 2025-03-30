package com.jalila.musiques.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.service.MusiqueService;

@Controller
public class MusiqueController {
    @Autowired
    MusiqueService musiqueService;

    @RequestMapping("/ListeMusiques")
    public String listeMusiques(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Musique> musiques = musiqueService.getAllMusiquesParPage(page, size);
        modelMap.addAttribute("musiques", musiques);
        modelMap.addAttribute("pages", new int[musiques.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMusiques";
    }

    @RequestMapping("/showCreateMusique")
    public String showCreate(ModelMap modelMap){
			modelMap.addAttribute("musique", new Musique());
			modelMap.addAttribute("mode", "new");
    	
        return "formMusique";
    }

    @RequestMapping("/saveMusique")
    public String saveMusique(@ModelAttribute("musique") Musique musique, 
            @RequestParam("dateSortie") String date,
            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSortie = dateformat.parse(date);
        musique.setDateSortie(dateSortie);

        Musique savedMusique = musiqueService.saveMusique(musique);
        String msg = "Musique enregistrée avec Id " + savedMusique.getIdMusique();
        modelMap.addAttribute("msg", msg);
        return ("redirect:/ListeMusiques");
    }

    @RequestMapping("/supprimerMusique")
    public String supprimerMusique(@RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        musiqueService.deleteMusiqueById(id);
        Page<Musique> musiques = musiqueService.getAllMusiquesParPage(page, size);
        modelMap.addAttribute("musiques", musiques);
        modelMap.addAttribute("pages", new int[musiques.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMusiques";
    }

    @RequestMapping("/modifierMusique")
    public String editerMusique(@RequestParam("id") Long id, ModelMap modelMap) {
        Musique m = musiqueService.getMusique(id);
        
        modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("musique", m);
        return "formMusique";
    }

    @RequestMapping("/updateMusique")
    public String updateMusique(@ModelAttribute("musique") Musique musique,
            @RequestParam("dateSortie") String date,
            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSortie = dateformat.parse(String.valueOf(date));
        musique.setDateSortie(dateSortie);
        musiqueService.updateMusique(musique);
        List<Musique> musiques = musiqueService.getAllMusiques();
        modelMap.addAttribute("musiques", musiques);
        return "listeMusiques";
    }
}