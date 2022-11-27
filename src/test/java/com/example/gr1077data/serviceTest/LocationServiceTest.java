package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.*;
import com.example.gr1077data.service.LocationService;
import com.example.gr1077data.service.RoomService;
import com.example.gr1077data.service.exception.LocationNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class LocationServiceTest {

    @Autowired
    LocationService locationService;
    @Autowired
    LocationRepo locationRepo;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepo roomRepo;

    Location location;
    Room room;
    Set<Room> roomSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        roomRepo.deleteAll();
        locationRepo.deleteAll();

        location = Location.builder().address("street1").build();
        locationRepo.save(location);
        room = Room.builder().name("r1").location(location).build();
        roomSet.add(room);
        room = Room.builder().name("r2").location(location).build();
        roomSet.add(room);


        location = Location.builder().address("street2").build();
        locationRepo.save(location);
        room = Room.builder().name("r3").location(location).build();
        roomSet.add(room);
        room = Room.builder().name("r4").location(location).build();
        roomSet.add(room);
        roomRepo.saveAll(roomSet);

    }

    @Test
    void add() throws LocationNotFoundException {
        roomSet = new HashSet<>();
        roomSet.add(Room.builder().location(location).name("r5").build());
        roomSet.add(Room.builder().location(location).name("r6").build());
        location = Location.builder().address("street3").roomSet(roomSet).build();
        locationRepo.save(location);
        Assertions.assertThat(locationService.getLocationByAddress("street3")).isNotNull();
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(locationService.getAllLocations()).hasSize(2);
    }

    @Test
    public void testGet() throws LocationNotFoundException {
        Assertions.assertThat(locationService.getLocationById(2L)).isNotNull();
    }

    @Test
    public void testDelete() throws LocationNotFoundException {
        List<Location> locations = locationRepo.findAll();
        int locationIndex = locations.size() - 1;
        Location location = locations.get(locationIndex);
        Long id = location.getId();
        locationService.deleteLocation(id);
        Assertions.assertThat(locationRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws LocationNotFoundException {
        List<Location> locations = locationRepo.findAll();
        int locationIndex = locations.size() - 1;
        Location location = locations.get(locationIndex);
        Long id = location.getId();
        location.setAddress("updatedTitle");
        locationRepo.save(location);
        Assertions.assertThat(locationRepo.findById(id).get().getAddress()).isEqualTo("updatedTitle");
    }
}
