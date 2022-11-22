package com.example.gr1077data.controller;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.service.ExternalResearchService;
import com.example.gr1077data.service.exception.ExternalResearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExternalResercherController {
    private final ExternalResearchService externalResearchService;
@Autowired
    public ExternalResercherController(ExternalResearchService externalResearchService) {
        this.externalResearchService = externalResearchService;
    }
    //get all external researches
    @GetMapping("/externalresearches")
    public ResponseEntity<List<ExternalResearcher>> getAllExternalResearches() throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.getAllExternalResearches(), HttpStatus.OK);
    }
    @GetMapping("/externalresearches/{id}")
    public ResponseEntity<ExternalResearcher> getExternalResearchById(@PathVariable Long id) throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.getExternalResearchById(id), HttpStatus.OK);
    }
    @PostMapping("/externalresearches")
    public ResponseEntity<ExternalResearcher> createExternalResearch(@RequestBody ExternalResearcher newexternalResearch) throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.createExternalResearch(newexternalResearch), HttpStatus.CREATED);
    }
    @DeleteMapping("/externalresearches/{id}")
    public ResponseEntity<ExternalResearcher> deleteExternalResearch(@PathVariable Long id) throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.deleteExternalResearch(id), HttpStatus.OK);
    }
    @PutMapping("/externalresearches/{id}")
    public ResponseEntity<ExternalResearcher> updateExternalResearch(@PathVariable Long id, @RequestBody ExternalResearcher externalResearch) throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.updateExternalResearch(id, externalResearch), HttpStatus.OK);
    }




}
