package com.example.gr1077data.controller;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.service.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event newEvent) throws SectionsSequenceException {
        return new ResponseEntity<>(eventService.create(newEvent), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> del(@PathVariable Long id) throws EventNotFoundException {
        return new ResponseEntity<>(eventService.del(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody Event event) throws EventNotFoundException, SectionsSequenceException {
        return new ResponseEntity<>(eventService.update(id, event), HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam(name = "keyword") String keyword) {
        return new ResponseEntity<>(eventService.search(keyword), HttpStatus.OK);
    }

}
