package com.example.gr1077data.service;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Image;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.enums.EventState;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepo eventRepo;
    private final SectionService<Event> sectionService;

    public List<Event> getAll() {
        return eventRepo.findAllEventsOrdered();
    }

    public Event getById(Long id) throws EventNotFoundException {

        return eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
    }

    public Event create(Event event) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(event))) throw new SectionsSequenceException("Invalid sections sequence");
        Image image = event.getImage();
        String url = event.getImage().getUrl();
        if(url.equalsIgnoreCase("")) {
            image.setUrl("https://i.imgur.com/VBL5PH4.png");
            event.setImage(image);
        }
        return eventRepo.save(event);
    }

    public void del(Long id) throws EventNotFoundException {
        eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        eventRepo.deleteById(id);
    }

    public Event update(Long id, Event event) throws SectionsSequenceException, EventNotFoundException {
        if (!(sectionService.isSequenceValid(event))) throw new SectionsSequenceException("Invalid sections sequence");
        eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        return eventRepo.save(event);
    }

    public List<Event> search(String keyword) {
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

    public boolean checkRoomIsAvailablePost(Long roomId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Event> events = eventRepo.findAllByRoomId(roomId);
        for (Event booking : events) {
            if (booking.getDate().equals(date)) {
                if (booking.getStartTime().equals(startTime) || booking.getEndTime().equals(endTime)) {
                    throw new IllegalStateException("Room is not available");
                } else if (booking.getStartTime().isBefore(startTime) && booking.getEndTime().isAfter(startTime)) {
                    throw new IllegalStateException("Room is not available");
                } else if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(endTime)) {
                    throw new IllegalStateException("Room is not available");
                }
            }
        }
        return true;
    }

    public boolean checkRoomIsAvailablePut(Long roomId, Long eventId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Event> events = eventRepo.findAllByRoomId(roomId)
                .stream().filter(event -> !event.getId().equals(eventId)).collect(Collectors.toList());
        for (Event booking : events) {
            if (booking.getDate().equals(date)) {
                if (booking.getStartTime().equals(startTime) || booking.getEndTime().equals(endTime)) {
                    throw new IllegalStateException("Room is not available!");
                } else if (booking.getStartTime().isBefore(startTime) && booking.getEndTime().isAfter(startTime)) {
                    throw new IllegalStateException("Room is not available!");
                } else if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(endTime)) {
                    throw new IllegalStateException("Room is not available!");
                }
            }
        }
        return true;
    }

    public EventState getState(Event event) {
        if (event.getDate().isBefore(LocalDate.now())) {
            return EventState.PAST;
        }
        if (event.getDate().isAfter(LocalDate.now())
                || event.getDate().isEqual(LocalDate.now())) {
            return EventState.UPCOMING;
        }
        return null;
    }

    public List<Event> getByState(EventState state) {
        List<Event> events = eventRepo.findAllEventsOrdered();

        return events.stream()
                    .filter(item -> getState(item) == state)
                    .toList();
    }



}
