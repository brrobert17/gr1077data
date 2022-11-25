package com.example.gr1077data.controller;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.*;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class EventController {
    private final EventService eventService;
    private final RoomService roomService;

    private final ImageService imageService;
    @Autowired
    public EventController(EventService eventService, RoomService roomService, ImageService imageService) {
        this.eventService = eventService;
        this.roomService = roomService;
        this.imageService = imageService;
    }





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
    public ResponseEntity<Event> createEvent(@RequestBody Event newEvent){
        //check if booking is possible or not with ActivityIsAvailable

        if (eventService.checkActivityIsAvailablePost(newEvent.getRoom().getId(), newEvent.getDate(), newEvent.getStartTime(), newEvent.getEndTime())
            && eventService.checkTime(newEvent)){
            Event event = eventService.createEvent(newEvent, newEvent.getRoom().getId());
        return new ResponseEntity<> (event,HttpStatus.CREATED);
    }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }
    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable ("id") Long id, @RequestBody Event event) throws EventNotFoundException
    {
       if (eventService.checkActivityIsAvailablePut(id,event.getRoom().getId(), event.getDate(), event.getStartTime(), event.getEndTime())&&
               eventService.checkTime(event)) {
           Event updatedEvent = eventService.updateEvent(id, event);
           return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
       }
         else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

     }
    //search events
    @GetMapping(value="/events", params = "keyword")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam ("keyword")String keyword) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.searchEvents(eventService.getAllEvents(),keyword), HttpStatus.OK);
    }
    //find by keyword and put it in list of customers







}
