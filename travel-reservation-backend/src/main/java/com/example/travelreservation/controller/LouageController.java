package com.example.travelreservation.controller;

import com.example.travelreservation.model.Louage;
import com.example.travelreservation.service.LouageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/louages")
public class LouageController {
    @Autowired
    private LouageService louageService;

    @GetMapping
    public List<Louage> getAllLouages() {
        return louageService.getAllLouages();
    }

    @GetMapping("/{id}")
    public Louage getLouageById(@PathVariable Long id) {
        return louageService.getLouageById(id);
    }

    @PostMapping
    public Louage createLouage(@RequestBody Louage louage) {
        return louageService.createLouage(louage);
    }

    @PutMapping("/{id}")
    public Louage updateLouage(@PathVariable Long id, @RequestBody Louage louage) {
        return louageService.updateLouage(louage);
    }

    @DeleteMapping("/{id}")
    public void deleteLouage(@PathVariable Long id) {
        louageService.deleteLouage(id);
    }
}