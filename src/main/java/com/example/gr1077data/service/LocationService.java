package com.example.gr1077data.service;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepo locationRepo;
    @Autowired
    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }
    //get all locations
    public List<Location> getAllLocations() {
        List<Location> locationList = locationRepo.findAll();
        return locationList;
    }
    //get location by id
    public Location getLocationById(Long id) {
        return locationRepo.findById(id).orElse(null);

    }
    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }
    public Location updateLocation(Long id, Location newLocation){
        if(locationRepo.findById(id).isEmpty()){
            return null;
        }
        return locationRepo.save(newLocation);
    }
    public void deleteLocation(Long id)  {
        locationRepo.deleteById(id);
    }
    //find location by keyword
    public List <Location> getLocationBykeyword(String keyword) {
        if (keyword != null) {
            return locationRepo.findByKeyword(keyword);
        }
        return locationRepo.findAll();
    }


}
