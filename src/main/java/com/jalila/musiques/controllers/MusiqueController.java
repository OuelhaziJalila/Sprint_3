package com.jalila.musiques.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.service.MusiqueService;

import jakarta.validation.Valid;

@Controller
public class MusiqueController {

    @Autowired
    MusiqueService musiqueService;

    @GetMapping("/accessDenied")
    public String error() {
        return "accessDenied";
    }

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

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("musique", new Musique());
        List<Genre> genres = musiqueService.getAllGenres();
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("genres", genres);
        return "formMusique";
    }

    @RequestMapping("/saveMusique")
    public String saveMusique(@Valid Musique musique, BindingResult bindingResult,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = false;

        if (bindingResult.hasErrors()) return "formMusique";
        if (musique.getIdMusique() == null) isNew = true;

        musiqueService.saveMusique(musique);

        if (isNew) {
            Page<Musique> musiques = musiqueService.getAllMusiquesParPage(page, size);
            currentPage = musiques.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/ListeMusiques?page=" + currentPage + "&size=" + size;
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
    public String editerMusique(@RequestParam("id") Long id, ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size) {
        Musique m = musiqueService.getMusique(id);
        List<Genre> genres = musiqueService.getAllGenres();
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("musique", m);
        modelMap.addAttribute("genres", genres);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formMusique";
    }

    @RequestMapping("/updateMusique")
    public String updateMusique(@ModelAttribute("musique") Musique musique,
                                @RequestParam("date") String date,
                                ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAjout = dateformat.parse(String.valueOf(date));
        musique.setDateSortie(dateAjout);

        musiqueService.updateMusique(musique);
        List<Musique> musiques = musiqueService.getAllMusiques();
        modelMap.addAttribute("musiques", musiques);
        return "listeMusiques";
    }

}
