package com.example.gr1077data.repo;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    //search room keword
    @Query("SELECT r FROM Room r WHERE r.name  LIKE %?1%")
    List<Room> findByKeyword(String keyword);

    //find the room with the same location
    @Query("SELECT r FROM Room r WHERE r.location.id = :locationId")
    List<Room> findByLocationId(@Param("locationId") Long locationId);
}
