package com.example.gr1077data.service;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParticipantService {
    private final ParticipantRepo participantRepo;

    @Autowired
    public ParticipantService(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }


    //get all customers
    public List<Participant> getAllParticipant() {
        List<Participant> participantsList = participantRepo.findAll();
        return participantsList;
    }


    //get customer by id
    public Participant getParticipantById(Long id) {
        return participantRepo.findById(id).orElse(null);
    }

    public Participant createParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    public Participant updateParticipant(Long id, Participant newParticipant){
        if(participantRepo.findById(id).isEmpty()){
            return null;
        }
        return participantRepo.save(newParticipant);
    }


    public void deleteParticipant(Long id)  {
        participantRepo.deleteById(id);
    }
    //find customer by keyword
    public List <Participant> findByKeyword(String keyword) {
        if (keyword != null) {
            return participantRepo.findByKeyword(keyword);
        }
        return participantRepo.findAll();
    }

}
