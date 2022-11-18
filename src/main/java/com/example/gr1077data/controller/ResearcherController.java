package com.example.gr1077data.controller;

import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/researcher")
@RequiredArgsConstructor
public class ResearcherController {

    final ResearcherService researcherService;

    @GetMapping
    public List<Researcher> findAllResearchers() {
        return researcherService.findAllResearchers();
    }

    @GetMapping("/findById")
    public Researcher findResearcherById(@RequestParam Long id) throws ResearcherNotFoundException {
        return researcherService.findResearcherById(id);
    }

    @GetMapping("/findByName")
    public List<Researcher> findResearcherByTitle(@RequestParam String name) {
        return researcherService.findResearchersByName(name);
    }

    @PostMapping
    public Researcher saveResearcher(@RequestBody Researcher researcher) throws ResearcherNotFoundException {
        Researcher savedResearcher = researcherService.saveResearcher(researcher);
        return researcherService.findResearcherById(savedResearcher.getId());
    }

    @DeleteMapping
    public Researcher deleteResearcherById(@RequestParam Long id) throws ResearcherNotFoundException {
        return researcherService.deleteResearcherById(id);
    }

    @PutMapping
    public Researcher updateResearcher(@RequestBody Researcher researcher) throws ResearcherNotFoundException {
        return researcherService.updateResearcher(researcher);
    }

}
