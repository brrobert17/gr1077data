package com.example.gr1077data.controller;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.service.ExternalResearcherService;
import com.example.gr1077data.service.exception.ExternalResearcherException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ExternalResearcherController {
    private final ExternalResearcherService externalResearcherService;

    //get all external researches
    @GetMapping("/externalResearchers")
    public ResponseEntity<List<ExternalResearcher>> getAllExternalResearches() throws ExternalResearcherException {
        return new ResponseEntity<>(externalResearcherService.getAllExternalResearches(), HttpStatus.OK);
    }
    @GetMapping("/externalResearchers/{id}")
    public ResponseEntity<ExternalResearcher> getExternalResearchById(@PathVariable Long id) throws ExternalResearcherException {
        return new ResponseEntity<>(externalResearcherService.getExternalResearchById(id), HttpStatus.OK);
    }
    @PostMapping("/externalResearchers")
    public ResponseEntity<ExternalResearcher> createExternalResearch(@RequestBody ExternalResearcher newExternalResearch) throws ExternalResearcherException {
        return new ResponseEntity<>(externalResearcherService.createExternalResearch(newExternalResearch), HttpStatus.CREATED);
    }
    @DeleteMapping("/externalResearchers/{id}")
    public ResponseEntity<ExternalResearcher> deleteExternalResearch(@PathVariable Long id) throws ExternalResearcherException {
        return new ResponseEntity<>(externalResearcherService.deleteExternalResearch(id), HttpStatus.OK);
    }
    @PutMapping("/externalResearchers/{id}")
    public ResponseEntity<ExternalResearcher> updateExternalResearch(@PathVariable Long id, @RequestBody ExternalResearcher externalResearch) throws ExternalResearcherException {
        return new ResponseEntity<>(externalResearcherService.updateExternalResearch(id, externalResearch), HttpStatus.OK);
    }

}
