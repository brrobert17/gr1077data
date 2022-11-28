package com.example.gr1077data.service;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepo eventRepo;
    private final SectionService<Event> sectionService;

    public List<Event> getAll() {
        return eventRepo.findAll();
    }

    public Event getById(Long id) throws EventNotFoundException {
        return eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
    }

    public Event create(Event event) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(event))) throw new SectionsSequenceException("Invalid sections sequence");
        return eventRepo.save(event);
    }

    public Event del(Long id) throws EventNotFoundException {
        Event event = eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        eventRepo.delete(event);
        return event;
    }

    public Event update(Long id, Event event) throws SectionsSequenceException, EventNotFoundException {
        if (!(sectionService.isSequenceValid(event))) throw new SectionsSequenceException("Invalid sections sequence");
        eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        return eventRepo.save(event);
    }

    public List<Event> search(String keyword){
        return eventRepo.findByName(keyword);
    }

    //no event in past date in Danish time and local time
    public boolean checkTime(Event event) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        if (event.getDate().isBefore(today)) {
            throw new IllegalStateException("Date is in the past");
        }
        if (event.getDate().equals(today)) {
            if (event.getStartTime().isBefore(now)) {
                throw new IllegalStateException("We are in the past");
            }
        }
        return true;
    }

}
