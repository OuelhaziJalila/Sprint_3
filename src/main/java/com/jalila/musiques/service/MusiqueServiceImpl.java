package com.jalila.musiques.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.repos.MusiqueRepository;

import jakarta.transaction.Transactional;

@Service
public class MusiqueServiceImpl implements MusiqueService {

    @Autowired
    MusiqueRepository musiqueRepository;
    
    @Override
    public Musique saveMusique(Musique m) {
        return musiqueRepository.save(m);
    }

    @Override
    public Musique updateMusique(Musique m) {
        return musiqueRepository.save(m);
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
    public Musique getMusique(Long id) {
        return musiqueRepository.findById(id).get();
    }

    @Override
    public List<Musique> getAllMusiques() {
        return musiqueRepository.findAll();
    }

    @Override
    public Page<Musique> getAllMusiquesParPage(int page, int size) {
        return musiqueRepository.findAll(PageRequest.of(page, size));
    }
}