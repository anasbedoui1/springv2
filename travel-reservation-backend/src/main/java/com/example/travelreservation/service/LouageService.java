package com.example.travelreservation.service;

import com.example.travelreservation.model.Louage;
import com.example.travelreservation.repository.LouageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LouageService {

    @Autowired
    private LouageRepository louageRepository;

    public List<Louage> getAllLouages() {
        return louageRepository.findAll();
    }

    public Louage getLouageById(Long id) {
        return louageRepository.findById(id).orElse(null);
    }

    public Louage createLouage(Louage louage) {
        return louageRepository.save(louage);
    }

    public Louage updateLouage(Louage louage) {
        return louageRepository.save(louage);
    }

    public void deleteLouage(Long id) {
        louageRepository.deleteById(id);
    }
}
