package com.example.gr1077data.repo;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    //search room keword
    @Query("SELECT r FROM Room r WHERE r.name  LIKE %?1%")
    List<Room> findByKeyword(String keyword);

    //find the room with the same location
    @Query("SELECT r FROM Room r WHERE r.location.id = :locationId")
    List<Room> findByLocationId(@Param("locationId") Long locationId);

    @Query("SELECT r from Room r WHERE r.location.id = :locationId AND r.name = :roomName")
    List<Room> findByRoomNameAndLocationId(@Param("locationId") Long locationId,
                                            @Param("roomName") String roomName);


    //room availability
    @Query(nativeQuery = true, value = "SELECT * FROM gr1077_db.room where id not in " +
            "(select distinct room_id from (select * from gr1077_db.event where date =:date) as `e*` where " +
            "start_time  between :start and :end or" +
            " end_time  between :start and :end or" +
            ":start  between start_time and end_time or" +
            ":end  between start_time and end_time);")
    List<Room> findRoomByAvailability(@Param("date") LocalDate date,
                                      @Param("start") LocalTime start,
                                      @Param("end") LocalTime end);
}
