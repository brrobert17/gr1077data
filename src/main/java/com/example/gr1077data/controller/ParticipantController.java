package com.example.gr1077data.controller;


import com.example.gr1077data.model.Participant;
import com.example.gr1077data.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ParticipantController {
    private final ParticipantService participantService;
    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }
    //return all customers
    @GetMapping("/participants")
    public List<Participant> getAllParticipant(){
        return participantService.getAllParticipant();
    }



    //return customer by id
    @GetMapping("/participants/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable("id") Long id){
        Participant participant = participantService.getParticipantById(id);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    //Create customer
    @PostMapping("/participants")
    public Participant createParticipant(@RequestBody Participant newParticipant){
        return participantService.createParticipant(newParticipant);
    }

    @PutMapping("/participants/{id}")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant newParticipant, @PathVariable("id")Long id){
        if(id==null || id<=0 || newParticipant==null || newParticipant.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Participant participant = participantService.updateParticipant(id, newParticipant);
            return new ResponseEntity<>(participant, HttpStatus.OK);
        }
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable("id") Long id){
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //find by keyword and put it in list of customers
    @GetMapping("/participants/search/{keyword}")
    public List<Participant> findByKeyword(@PathVariable("keyword") String keyword){
        return participantService.findByKeyword(keyword);
    }

}
