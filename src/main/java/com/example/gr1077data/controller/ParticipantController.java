package com.example.gr1077data.controller;


import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.service.EventService;
import com.example.gr1077data.service.ParticipantService;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping
    public List<Participant> getAll() throws ParticipantNotFoundException {
        return participantService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Participant> getById(@PathVariable("id") Long id)throws ParticipantNotFoundException{
        Participant participant = participantService.getById(id);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PostMapping(params = "eventId")
    public Participant create(@RequestBody Participant newParticipant, @RequestParam("eventId" )Long eventId) throws ParticipantNotFoundException, EventNotFoundException, SectionsSequenceException {
        return participantService.create(newParticipant, eventId);
    }

    @PutMapping("{id}")
    public ResponseEntity<Participant> update(@RequestBody Participant newParticipant, @PathVariable("id")Long id)throws ParticipantNotFoundException{
        if(id==null || id<=0 || newParticipant==null || newParticipant.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Participant participant = participantService.update(id, newParticipant);
            return new ResponseEntity<>(participant, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> del(@PathVariable("id") Long id) throws ParticipantNotFoundException{
        participantService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //find by keyword and put it in list of customers
    @GetMapping(value = "/participants",params = "keyword")
    public List<Participant> findByKeyWord(@RequestParam("keyword") String keyword)throws ParticipantNotFoundException{
        return participantService.findByKeyword(keyword);
    }

}
