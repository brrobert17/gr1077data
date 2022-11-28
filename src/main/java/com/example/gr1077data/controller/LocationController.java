package com.example.gr1077data.controller;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.service.LocationService;
import com.example.gr1077data.service.exception.LocationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        List<Location> locations = locationService.getAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Location> getById(@PathVariable("id") Long id) throws LocationNotFoundException {
        Location location = locationService.getById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Location> create(@RequestBody Location newLocation){
        Location location = locationService.create(newLocation);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Location> update(@RequestBody Location newLocation, @PathVariable("id")Long id){
        if(id==null || id<=0 || newLocation==null || newLocation.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Location location = locationService.update(id, newLocation);
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> del(@PathVariable("id") Long id){
        locationService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<Location>> getByKeyword(@RequestParam String keyword){
        List<Location> locations = locationService.getByKeyword(keyword);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

}
