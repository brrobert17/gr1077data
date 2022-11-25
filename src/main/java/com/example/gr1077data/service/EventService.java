package com.example.gr1077data.service;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.exception.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    //get all events
    public List<Event> getAllEvents() throws EventNotFoundException {
        List<Event> eventList = eventRepo.findAll();
        return eventList;
    }

    public Event getEventById(Long id) throws EventNotFoundException {
        Event event = eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        return event;
    }
    //create event
    public Event createEvent(Event event) throws EventNotFoundException {
        Event newEvent = eventRepo.save(event);
        return newEvent;
    }
    //delete event
    public Event deleteEvent(Long id) throws EventNotFoundException {
        Event event = eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        eventRepo.delete(event);
        return event;
    }
    //update event
    public Event updateEvent(Long id,Event event){
        if(eventRepo.findById(id).isEmpty()){
            return null;
        }
        return eventRepo.save(event);
    }
    //search event
    public List<Event> searchEvent(String keyword){
        return eventRepo.searchEvent(keyword);
    }


    //no booking in past date in Danish time and local time
    public boolean checkTime(Event booking) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        if (booking.getDate().isBefore(today)) {
            throw new IllegalStateException("Date is in the past");
        }
        if (booking.getDate().equals(today)) {
            if (booking.getStartTime().isBefore(now)) {
                throw new IllegalStateException("We are in the past");
            }
        }
        return true;
    }


}
