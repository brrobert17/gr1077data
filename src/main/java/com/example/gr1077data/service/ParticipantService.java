package com.example.gr1077data.service;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.ParticipantRepo;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ParticipantService {

    private final ParticipantRepo participantRepo;
    private final EventService eventService;

    public List<Participant> getAll() {
        return participantRepo.findAll();
    }

    public Participant getById(Long id) throws ParticipantNotFoundException{
        return participantRepo.findById(id).orElse(null);
    }

    public Participant create(Participant participant, Long eventId) throws ParticipantNotFoundException, EventNotFoundException, SectionsSequenceException {
        Event event = eventService.getById(eventId);
        Set<Participant> participantSet = event.getParticipantSet();
        participantSet.add(participant);
        event.setParticipantSet(participantSet);
        eventService.update(eventId, event);
        return participant;
    }

    public Participant createNullEvent (Participant participant) {
        return participantRepo.save(participant);
    }

    public Participant update(Long id, Participant newParticipant) throws ParticipantNotFoundException{
        if(participantRepo.findById(id).isEmpty()){
            return null;
        }
        return participantRepo.save(newParticipant);
    }

    public void del(Long id) throws ParticipantNotFoundException  {
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
