package com.example.gr1077data.controller;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LocationController {
    private final LocationService locationService;
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id){
        Location location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location newLocation){
        Location location = locationService.createLocation(newLocation);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@RequestBody Location newLocation, @PathVariable("id")Long id){
        if(id==null || id<=0 || newLocation==null || newLocation.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Location location = locationService.updateLocation(id, newLocation);
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
    }
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") Long id){
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/locations", params = "locationName")
    public ResponseEntity<List<Location>> getLocationBykeyword(@RequestParam(name="keyword") String keyword){
        List<Location> locations = locationService.getLocationBykeyword(keyword);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

}
