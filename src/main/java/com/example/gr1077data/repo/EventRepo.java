package com.example.gr1077data.repo;

import com.example.gr1077data.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    //SEARCH BY KEYWORD
    @Query("SELECT e FROM Event e WHERE e.name LIKE %?1% OR e.description LIKE %?1%")
    List<Event> searchEvent(String keyword);

    //find all event by room  id
    @Query("SELECT b FROM Event AS b WHERE b.room.id=?1")
        List<Event> findAllByRoomId (Long roomId);
}
