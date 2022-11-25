package com.example.gr1077data.service;

import com.example.gr1077data.model.Room;
import com.example.gr1077data.repo.RoomRepo;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepo roomRepo;
    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }
    //get all rooms
    public List<Room> getAllRooms() throws RoomNotFoundException {
        List<Room> roomList = roomRepo.findAll() ;
        return roomList;
    }
    //get room by id
    public Room getRoomById(Long id)  {
        return roomRepo.findById(id).orElse(null);

    }
    public Room createRoom(Room room)throws RoomNotFoundException {
        return roomRepo.save(room);
    }
    public Room updateRoom(Long id, Room newRoom) throws RoomNotFoundException {
        if(roomRepo.findById(id).isEmpty()){
            return null;
        }
        return roomRepo.save(newRoom);
    }
    public void deleteRoom(Long id) throws RoomNotFoundException {
        roomRepo.deleteById(id);
    }
    //find room by keyword
    public List <Room> getRoomBykeyword(String keyword) throws RoomNotFoundException {
        if (keyword != null) {
            return roomRepo.findByKeyword(keyword);
        }
        return roomRepo.findAll();
    }
    //find the same location room
    public List <Room> getRoomByLocationId(Long locationId) throws RoomNotFoundException {
        if (locationId != null) {
            return roomRepo.findByLocationId(locationId);
        }
        return roomRepo.findAll();
    }
}
