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
    public ResponseEntity<List<Researcher>> findAllResearchers() {
        return new ResponseEntity<>(researcherService.findAllResearchers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Researcher> findResearcherById(@PathVariable Long id) throws ResearcherNotFoundException {
        return new ResponseEntity<>(researcherService.findResearcherById(id), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Researcher>> findResearcherByTitle(@RequestParam String name) {
        return new ResponseEntity<>(researcherService.findResearchersByName(name),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Researcher> saveResearcher(@RequestBody Researcher researcher) throws ResearcherNotFoundException {
        Researcher savedResearcher = researcherService.saveResearcher(researcher);
        return new ResponseEntity<>(researcherService.findResearcherById(savedResearcher.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Researcher> deleteResearcherById(@PathVariable Long id) throws ResearcherNotFoundException {
        return new ResponseEntity<>(researcherService.deleteResearcherById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Researcher> updateResearcher(@PathVariable Long id, @RequestBody Researcher researcher) throws ResearcherNotFoundException {
        if(id ==null || id <=0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(researcherService.updateResearcher(id, researcher),HttpStatus.OK);
    }

}
