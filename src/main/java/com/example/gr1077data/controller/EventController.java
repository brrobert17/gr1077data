package com.example.gr1077data.controller;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.*;
import com.example.gr1077data.service.exception.EventNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class EventController {
    private final EventService eventService;





    //get all events
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() throws EventNotFoundException {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);

    }
    //get event by id
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
    }
    //creat events
    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event newEvent) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.createEvent(newEvent), HttpStatus.CREATED);
    }
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }
    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.updateEvent(id, event), HttpStatus.OK);
    }
    //search events
    @GetMapping("/events/search")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam String search) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.searchEvent(search), HttpStatus.OK);
    }







}
