package com.example.gr1077data.controller;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.service.ExternalResearcherService;
import com.example.gr1077data.service.exception.ExternalResearcherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/externalResearchers")
public class ExternalResearcherController {
    private final ExternalResearcherService externalResearcherService;

    @GetMapping
    public ResponseEntity<List<ExternalResearcher>> getAll() {
        return new ResponseEntity<>(externalResearcherService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<ExternalResearcher> getById(@PathVariable Long id) throws ExternalResearcherNotFoundException {
        return new ResponseEntity<>(externalResearcherService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ExternalResearcher> create(@RequestBody ExternalResearcher newExternalResearcher) {
        return new ResponseEntity<>(externalResearcherService.create(newExternalResearcher), HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ExternalResearcher> del(@PathVariable Long id) throws ExternalResearcherNotFoundException {
        return new ResponseEntity<>(externalResearcherService.del(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<ExternalResearcher> update(@PathVariable Long id, @RequestBody ExternalResearcher externalResearcher) throws ExternalResearcherNotFoundException {
        return new ResponseEntity<>(externalResearcherService.update(id, externalResearcher), HttpStatus.OK);
    }

}
