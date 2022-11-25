package com.example.gr1077data.service;

import com.example.gr1077data.model.Event;
import com.example.gr1077data.model.Room;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {
    private final EventRepo eventRepo;
    private final RoomService roomService;


    @Autowired
    public EventService(EventRepo eventRepo, RoomService roomService) {
        this.eventRepo = eventRepo;
        this.roomService = roomService;

    }

    //get all events
    public List<Event> getAllEvents() throws EventNotFoundException {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) throws EventNotFoundException {
        Event event = eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found by: " + id));
        return event;
    }
    //create event
    public Event createEvent(Event event,Long roomId){
        //can creat image and room
        Room room = roomService.getRoomById(roomId);
        event.setRoom(room);
        return eventRepo.save(event);

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




    //no booking in past date in Danish time and local time
    public boolean checkTime(Event booking) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        if (booking.getDate().isBefore(today)) {
            throw new IllegalStateException("we are in the past ");
        }
        if (booking.getDate().equals(today)) {
            if (booking.getStartTime().isBefore(now)) {
                throw new IllegalStateException("We are in the past");
            }
        }
        return true;
    }
    //search event by date,used in event controller
    public List<Event> searchEvents(List<Event> bookingList,String date) {
        List<Event> searchList = new ArrayList<>();

        String[] result = date.split("-");
        int year = Integer.parseInt(result[0]);
        int month = Integer.parseInt(result[1]);
        int day = Integer.parseInt(result[2]);

        LocalDate localDate = LocalDate.of(year, month, day);

        for (Event booking : bookingList
        ) {
            if (booking.getDate().isEqual(localDate)) {
                searchList.add(booking);
            }
        }
        return searchList;
    }


    public boolean checkActivityIsAvailablePost(Long roomId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Event> events = eventRepo.findAllByRoomId( roomId);
        List<Event> availableEvents = new ArrayList<>();
        for (Event booking : events) {
            if (booking.getDate().equals(date)) {
                if (booking.getStartTime().equals(startTime) || booking.getEndTime().equals(endTime)) {
                    availableEvents.add(booking);
                    throw new IllegalStateException("Room is not available");

                } else if (booking.getStartTime().isBefore(startTime) && booking.getEndTime().isAfter(startTime)) {
                    availableEvents.add(booking);
                    throw new IllegalStateException("Room is not available");
                } else if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(endTime)) {
                    availableEvents.add(booking);
                    throw new IllegalStateException("Room is not available");
                }

            }

        }
        return true;
    }


    public boolean checkActivityIsAvailablePut(Long roomId, Long id, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Event> bookings = eventRepo.findAllByRoomId(roomId);
        bookings = bookings.stream().filter(item -> item.getId() != id).collect(Collectors.toList());
        List<Event> availableBookings = new ArrayList<>();
        for (Event booking : bookings) {
            if (booking.getDate().equals(date)) {
                if (booking.getStartTime().equals(startTime) || booking.getEndTime().equals(endTime)) {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");

                } else if (booking.getStartTime().isBefore(startTime) && booking.getEndTime().isAfter(startTime)) {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");
                } else if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(endTime)) {
                    availableBookings.add(booking);
                    throw new IllegalStateException("Activity is not available");
                }

            }

        }
        return true;
    }
    }

