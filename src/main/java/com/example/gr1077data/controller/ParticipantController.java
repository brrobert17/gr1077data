package com.example.gr1077data.controller;


import com.example.gr1077data.model.Participant;
import com.example.gr1077data.service.ParticipantService;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Participant create(@RequestBody Participant newParticipant) throws ParticipantNotFoundException{
        return participantService.create(newParticipant);
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
