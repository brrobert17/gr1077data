package com.example.gr1077data.controller;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Room;
import com.example.gr1077data.service.EventService;
import com.example.gr1077data.service.RoomService;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class RoomController {

    private final RoomService roomService;
    private final EventService eventService;
    @Autowired
    public RoomController(RoomService roomService, EventService eventService) {
        this.roomService = roomService;
        this.eventService = eventService;
    }

    //get all rooms
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() throws RoomNotFoundException {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) throws RoomNotFoundException {
        Room room = roomService.getRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    //list of event in room by id
    // Endpoint to implement
    // GET /rooms ? availableDate=11-12-2022 & availableStart=11:00 & availableEnd=12:00
    // Get all room that are available on the specified date, start and end time
    @GetMapping("/rooms")
    public List<Room> getAvailableRooms(@RequestParam("availableDate") String date,
                                        @RequestParam("availableStart") String start,
                                        @RequestParam("availableEnd") String end) {
        return roomService.getAvailableRooms(availableDate, availableStart, availableEnd);
    }

    @GetMapping("/rooms/{id}/events")
    public List<Event> getRoomByEventId(@PathVariable("id") Long id, @RequestParam(name="date") List date) throws RoomNotFoundException {
        return eventService.searchEvents(
                roomService.getRoomById(id)
                        .getEvents()
                        .stream()
                        .toList(),
                date.toString()
        );


    }
    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room newRoom) throws RoomNotFoundException {
        Room room = roomService.createRoom(newRoom);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }
    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room newRoom, @PathVariable("id")Long id)throws RoomNotFoundException {
        if(id==null || id<=0 || newRoom==null || newRoom.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Room room = roomService.updateRoom(id, newRoom);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
    }
    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) throws RoomNotFoundException {
        //only delete room not location
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/rooms", params = "roomNumber")
    public ResponseEntity<List<Room>> getRoomByKeyword(@RequestParam(name="keyword") String keyword)throws RoomNotFoundException{
        List<Room> rooms = roomService.getRoomBykeyword(keyword);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

}
