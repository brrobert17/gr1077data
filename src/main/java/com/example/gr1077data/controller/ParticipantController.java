package com.example.gr1077data.controller;


import com.example.gr1077data.model.Participant;
import com.example.gr1077data.service.ParticipantService;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    //return all customers
    @GetMapping("/participants")
    public List<Participant> getAllParticipant() throws ParticipantNotFoundException {
        return participantService.getAllParticipant();
    }

    //return customer by id
    @GetMapping("/participants/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable("id") Long id)throws ParticipantNotFoundException{
        Participant participant = participantService.getParticipantById(id);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    //Create customer
    @PostMapping("/participants")
    public Participant createParticipant(@RequestBody Participant newParticipant) throws ParticipantNotFoundException{
        return participantService.createParticipant(newParticipant);
    }

    @PutMapping("/participants/{id}")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant newParticipant, @PathVariable("id")Long id)throws ParticipantNotFoundException{
        if(id==null || id<=0 || newParticipant==null || newParticipant.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Participant participant = participantService.updateParticipant(id, newParticipant);
            return new ResponseEntity<>(participant, HttpStatus.OK);
        }
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable("id") Long id) throws ParticipantNotFoundException{
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //find by keyword and put it in list of customers
    @GetMapping(value = "/participants",params = "keyword")
    public List<Participant> findParticipantByKeyword(@RequestParam("keyword") String keyword)throws ParticipantNotFoundException{
        return participantService.findByKeyword(keyword);
    }

}
