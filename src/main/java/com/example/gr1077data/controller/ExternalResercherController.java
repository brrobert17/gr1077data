package com.example.gr1077data.controller;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.ExternalResearchService;
import com.example.gr1077data.service.ImageService;
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
    private final ImageService imageService;
    private final BlogPostService blogPostService;


@Autowired
    public ExternalResercherController(ExternalResearchService externalResearchService, ImageService imageService, BlogPostService blogPostService) {
        this.externalResearchService = externalResearchService;
        this.imageService = imageService;
        this.blogPostService = blogPostService;
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
    public ResponseEntity<ExternalResearcher> addExternalResearch(@RequestBody ExternalResearcher externalResearcher) throws ExternalResearchException {
        return new ResponseEntity<>(externalResearchService.createExternalResearch(externalResearcher), HttpStatus.CREATED);
    }









        @DeleteMapping("/externalresearches/{id}")
    public ResponseEntity<?> deleteExternalResearch(@PathVariable("id") Long id) throws ExternalResearchException {
        if(id==null || id<=0 || externalResearchService.getExternalResearchById(id)==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            externalResearchService.deleteExternalResearch(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PutMapping("/externalresearches/{id}")
    public ResponseEntity<ExternalResearcher> updateExternalResearch(@PathVariable Long id, @RequestBody ExternalResearcher newexternalResearch) throws ExternalResearchException {
        if(id==null || id<=0 || newexternalResearch==null || newexternalResearch.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            ExternalResearcher externalResearcher = externalResearchService.updateExternalResearch(id, newexternalResearch);
            return new ResponseEntity<>(externalResearcher, HttpStatus.OK);
        }

    }




}
