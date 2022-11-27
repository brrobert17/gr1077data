package com.example.gr1077data.controller;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.model.OtherPage;
import com.example.gr1077data.service.LocationService;
import com.example.gr1077data.service.OtherPageService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/other-pages")
public class OtherPageController {

    private final OtherPageService otherPageService;

    @Autowired
    public OtherPageController(OtherPageService otherPageService) {
        this.otherPageService = otherPageService;
    }

    @GetMapping("")
    public ResponseEntity<List<OtherPage>> getAll() {
        List<OtherPage> pages= otherPageService.getAll();
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OtherPage> getById(@PathVariable("id") Long id) throws BlogPostNotFoundException {
        OtherPage page = otherPageService.getById(id);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<OtherPage> create(@RequestBody OtherPage newPage) throws SectionsSequenceException {
        OtherPage location = otherPageService.save(newPage);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OtherPage> update(@RequestBody OtherPage updatedPage, @PathVariable("id")Long id) throws SectionsSequenceException {
        if(id==null || id<=0 || updatedPage==null || updatedPage.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            OtherPage page = otherPageService.update(id, updatedPage);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws BlogPostNotFoundException {
        otherPageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
