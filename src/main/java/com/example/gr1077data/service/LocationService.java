package com.example.gr1077data.service;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.repo.LocationRepo;
import com.example.gr1077data.service.exception.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepo locationRepo;

    @Autowired
    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public List<Location> getAll() {
        return locationRepo.findAll();
    }

    public Location getById(Long id) throws LocationNotFoundException {
        Optional<Location> optionalLocation = locationRepo.findById(id);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("location not found by id: " + id);
        }
        return optionalLocation.get();
    }

    public Location create(Location location) {
        return locationRepo.save(location);
    }

    public Location update(Long id, Location newLocation) {
        if (locationRepo.findById(id).isEmpty()) {
            return null;
        }
        return locationRepo.save(newLocation);
    }

    public void del(Long id) {
        locationRepo.deleteById(id);
    }

    public List<Location> getByKeyword(String keyword) {
        if (keyword != null ) {
            return locationRepo.findByKeyword(keyword);
        }
        return locationRepo.findAll();
    }

    public Location getByAddress(String address) throws LocationNotFoundException {
        return locationRepo.findByAddress(address).orElseThrow(()->
                new LocationNotFoundException("location not found by address: " + address));    }
}
