package com.example.gr1077data.controller;

import com.example.gr1077data.model.Room;
import com.example.gr1077data.service.RoomService;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAll() {
        List<Room> rooms = roomService.getAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") Long id) throws RoomNotFoundException {
        Room room = roomService.getById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room newRoom) {
        Room room = roomService.create(newRoom);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Room> update(@RequestBody Room newRoom, @PathVariable("id") Long id) throws RoomNotFoundException {
        if (id == null || id <= 0 || newRoom == null || newRoom.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Room room = roomService.update(id, newRoom);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> del(@PathVariable("id") Long id) throws RoomNotFoundException {
        roomService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<Room>> getByKeyword(@RequestParam String keyword) throws RoomNotFoundException {
        List<Room> rooms = roomService.getByKeyword(keyword);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("available")
    public List<Room> getAvailable(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                   @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime start,
                                   @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime end) {
        return roomService.findByAvailability(date, start, end);
    }

}
