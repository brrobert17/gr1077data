package com.example.gr1077data.controller;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.service.*;
import com.example.gr1077data.service.enums.EventState;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) throws SectionsSequenceException {
        if (eventService.checkRoomIsAvailablePost(event.getRoom().getId(), event.getDate(), event.getStartTime(), event.getEndTime())
                && eventService.checkTime(event)){
            return new ResponseEntity<> (eventService.create(event),HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> del(@PathVariable Long id) throws EventNotFoundException {
        eventService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody Event event) throws EventNotFoundException, SectionsSequenceException {
        if (eventService.checkRoomIsAvailablePut(event.getRoom().getId(), id, event.getDate(), event.getStartTime(), event.getEndTime())) {
            return new ResponseEntity<>(eventService.update(id, event), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam(name = "keyword") String keyword) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.search(keyword), HttpStatus.OK);
    }

    @GetMapping(params = "state")
    public ResponseEntity<List<Event>> getPast(@RequestParam(name = "state") EventState state ) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.getByState(state), HttpStatus.OK);
    }
    @GetMapping(params = {"keyword", "state"})
    public ResponseEntity<List<Event>> searchKeyword(@RequestParam(name = "keyword") String keyword, @RequestParam(name = "state") EventState state ) throws EventNotFoundException {
        List<Event> events = eventService.search(keyword)
                .stream()
                .filter(event -> eventService.getState(event) == state)
                .toList();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
