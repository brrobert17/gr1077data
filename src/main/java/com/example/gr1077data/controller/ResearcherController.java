package com.example.gr1077data.controller;

import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/researchers")
@RequiredArgsConstructor
public class ResearcherController {

    final ResearcherService researcherService;

    @GetMapping
    public ResponseEntity<List<Researcher>> getAll() {
        return new ResponseEntity<>(researcherService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Researcher> getById(@PathVariable Long id) throws ResearcherNotFoundException {
        return new ResponseEntity<>(researcherService.getById(id), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Researcher>> getByTitle(@RequestParam String name) {
        return new ResponseEntity<>(researcherService.findByName(name),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Researcher> save(@RequestBody Researcher researcher) throws ResearcherNotFoundException, SectionsSequenceException {
        return new ResponseEntity<>(researcherService.save(researcher), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> del(@PathVariable Long id) throws ResearcherNotFoundException {
        researcherService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Researcher> update(@PathVariable Long id, @RequestBody Researcher researcher) throws ResearcherNotFoundException {
        if(id ==null || id <=0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(researcherService.update(id, researcher),HttpStatus.OK);
    }

}
