package com.example.gr1077data.service;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.model.Room;
import com.example.gr1077data.repo.RoomRepo;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepo roomRepo;

    public List<Room> getAll() {
        return roomRepo.findAll();
    }

    public Room getById(Long id) {
        return roomRepo.findById(id).orElse(null);
    }

    public Room create(Room room) throws RoomNotFoundException {
        return roomRepo.save(room);
    }

    public Room update(Long id, Room newRoom) throws RoomNotFoundException {
        if (roomRepo.findById(id).isEmpty()) {
            return null;
        }
        return roomRepo.save(newRoom);
    }

    public void del(Long id) throws RoomNotFoundException {
        roomRepo.deleteById(id);
    }

    public List<Room> getByKeyword(String keyword) {
        if (keyword != null) {
            return roomRepo.findByKeyword(keyword);
        }
        return roomRepo.findAll();
    }

    //find the same location room
    public List<Room> getRoomByLocationId(Long locationId) {
        if (locationId != null) {
            return roomRepo.findByLocationId(locationId);
        }
        return roomRepo.findAll();
    }

    public List<Room> getByRoomNameAndLocationId(Long id, String name) {
        return roomRepo.findByRoomNameAndLocationId(id, name);
    }

    public List<Room> findByAvailability(LocalDate date, LocalTime start, LocalTime end) {
        return roomRepo.findRoomByAvailability(date, start, end);
    }

    public Location getLocationByRoomId(Long roomId) throws RoomNotFoundException {
        Optional<Room> optionalRoom = roomRepo.findById(roomId);
        if (optionalRoom.isPresent()) {
            return optionalRoom.get().getLocation();
        }
        else throw new RoomNotFoundException("Room/Location not found by RoomId: "+ roomId);
    }
}
