package com.example.gr1077data.controller;

import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/researchers")
@RequiredArgsConstructor
public class ResearcherController {

    final ResearcherService researcherService;

    @GetMapping
    public List<Researcher> findAllResearchers() {
        return researcherService.findAllResearchers();
    }

    @GetMapping("/{id}")
    public Researcher findResearcherById(@PathVariable Long id) throws ResearcherNotFoundException {
        return researcherService.findResearcherById(id);
    }

    @GetMapping(params = "name")
    public List<Researcher> findResearcherByTitle(@RequestParam String name) {
        return researcherService.findResearchersByName(name);
    }

    @PostMapping
    public Researcher saveResearcher(@RequestBody Researcher researcher) throws ResearcherNotFoundException {
        Researcher savedResearcher = researcherService.saveResearcher(researcher);
        return researcherService.findResearcherById(savedResearcher.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteResearcherById(@PathVariable Long id) throws ResearcherNotFoundException {
        researcherService.deleteResearcherById(id);
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Researcher updateResearcher(@PathVariable Long id, @RequestBody Researcher researcher) throws ResearcherNotFoundException {
        return researcherService.updateResearcher(id, researcher);
    }

}
