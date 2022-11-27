package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.model.Room;
import com.example.gr1077data.repo.LocationRepo;
import com.example.gr1077data.repo.RoomRepo;
import com.example.gr1077data.service.LocationService;
import com.example.gr1077data.service.RoomService;
import com.example.gr1077data.service.exception.LocationNotFoundException;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RoomServiceTest {
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
        room = Room.builder().location(location).name("r5").build();
        List<Location> locations = locationRepo.findAll();
        int locationIndex = locations.size() - 1;
        Location location = locations.get(locationIndex);
        Long id = location.getId();
        Assertions.assertThat(roomService.getRoomByRoomNameAndLocationId(id,"r5")).isNotNull();
    }

    @Test
    public void testListAll() throws LocationNotFoundException {
        List<Location> locations = locationRepo.findAll();
        int locationIndex = locations.size() - 1;
        Location location = locations.get(locationIndex);
        Long id = location.getId();
        Assertions.assertThat(roomService.getRoomByLocationId(id)).hasSize(2);
        Assertions.assertThat(roomService.getAllRooms()).hasSize(4);
    }

    @Test
    public void testGet() throws RoomNotFoundException {
        Assertions.assertThat(roomService.getRoomById(2L)).isNotNull();
    }

    @Test
    public void testDelete() throws RoomNotFoundException {
        List<Room> rooms = roomRepo.findAll();
        int roomIndex = rooms.size() - 1;
        Room room = rooms.get(roomIndex);
        Long id = room.getId();
        roomService.deleteRoom(id);
        Assertions.assertThat(roomRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws RoomNotFoundException {
        List<Room> rooms = roomRepo.findAll();
        int roomIndex = rooms.size() - 1;
        Room room = rooms.get(roomIndex);
        Long id = room.getId();
        room.setName("updatedTitle");
        roomRepo.save(room);
        Assertions.assertThat(roomRepo.findById(id).get().getName()).isEqualTo("updatedTitle");
    }
}
