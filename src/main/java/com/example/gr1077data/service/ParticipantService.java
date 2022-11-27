package com.example.gr1077data.service;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.ParticipantRepo;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParticipantService {
    private final ParticipantRepo participantRepo;

    @Autowired
    public ParticipantService(ParticipantRepo participantRepo) throws ParticipantNotFoundException {
        this.participantRepo = participantRepo;
    }


    //get all customers
    public List<Participant> getAllParticipants() {
        return participantRepo.findAll();
    }


    //get customer by id
    public Participant getParticipantById(Long id) throws ParticipantNotFoundException{
        return participantRepo.findById(id).orElse(null);
    }

    public Participant createParticipant(Participant participant) throws ParticipantNotFoundException {
        return participantRepo.save(participant);
    }

    public Participant updateParticipant(Long id, Participant newParticipant) throws ParticipantNotFoundException{
        if(participantRepo.findById(id).isEmpty()){
            return null;
        }
        return participantRepo.save(newParticipant);
    }


    public void deleteParticipant(Long id) throws ParticipantNotFoundException  {
        participantRepo.deleteById(id);
    }
    //find customer by keyword
    public List <Participant> findByKeyword(String keyword) throws ParticipantNotFoundException {
        if (keyword != null) {
            return participantRepo.findByKeyword(keyword);
        }
        return participantRepo.findAll();
    }

}
