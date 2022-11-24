package com.example.gr1077data.service;

import com.example.gr1077data.model.Location;
import com.example.gr1077data.model.Room;
import com.example.gr1077data.repo.RoomRepo;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class RoomTest {

    @Mock
    private RoomRepo roomRepo;
    private RoomService roomService;
    private Room room;
    private Long id;

    //get all rooms
    @BeforeEach

    void setUp() {
        roomService = new RoomService(roomRepo);
        Room room = Room.builder().id(1L).name("room1").location(new Location().builder().id(1L).address("location1").build()).build();
        id = 1L;
    }
    //test get all rooms
    @Test
    void canGetAllRooms() throws RoomNotFoundException {
        roomService.getAllRooms();
        Mockito.verify(roomRepo).findAll();

    }
    //test get room by id
    @Test
    void canGetRoomById() throws RoomNotFoundException {
        roomService.getRoomById(id);
        Mockito.verify(roomRepo).findById(id);
    }
    //test create room
    @Test
    void canCreateRoom() throws RoomNotFoundException {
        //Arrange
        Room room = Room.builder().id(1L).name("room1").location(new Location().builder().id(1L).address("location1").build()).build();
        //Act
        roomService.createRoom(room);
        //Assert
        ArgumentCaptor<Room> roomArgumentCaptor = ArgumentCaptor.forClass(Room.class);
        Mockito.verify(roomRepo).save(roomArgumentCaptor.capture());
        Room capturedRoom = roomArgumentCaptor.getValue();
        assertThat(capturedRoom).isEqualTo(room);

    }
    //test update room whith room if
    @Test
    void canUpdateRoom() throws RoomNotFoundException {
        //Arrange
        Room newRoom = Room.builder().id(1L).name("room2").location(new Location().builder().id(2L).address("location2").build()).build();
        //act
        roomService.updateRoom(id, newRoom);
        //assert
        ArgumentCaptor<Room> roomArgumentCaptor = ArgumentCaptor.forClass(Room.class);
        Mockito.verify(roomRepo).save(roomArgumentCaptor.capture());
        Room capturedRoom = roomArgumentCaptor.getValue();
        assertThat(capturedRoom).isEqualTo(newRoom);

    }



    //test delete room
    @Test
    void canDeleteRoom() throws RoomNotFoundException {
        roomService.deleteRoom(id);
        Mockito.verify(roomRepo).deleteById(id);
    }
    @Test
    void canGetRoomByKeyword() throws RoomNotFoundException {
        roomService.getRoomBykeyword("keyword");
        Mockito.verify(roomRepo).findByKeyword("keyword");
    }

}
