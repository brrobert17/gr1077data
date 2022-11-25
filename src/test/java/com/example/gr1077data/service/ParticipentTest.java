package com.example.gr1077data.service;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.ParticipantRepo;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
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
public class ParticipentTest {

    @Mock
    private ParticipantRepo participantRepo;
    private ParticipantService participantService;
    private Participant participant;
    private Long id;
    @BeforeEach
    void setUp() throws ParticipantNotFoundException {
        participantService = new ParticipantService(participantRepo);
        Participant participant = Participant.builder().id(1L).firstName("participant1").lastName("participant1").email("participant1")
                .affiliation("participant1").title("participant1").build();
        id = 10L;
    }

    @Test
    void canGetParticipantById() throws ParticipantNotFoundException {
        participantService.getParticipantById(id);
        Mockito.verify(participantRepo).findById(id);
    }
    @Test
    void canCreateParticipant() throws ParticipantNotFoundException {
        //Act
        participantService.createParticipant(participant);
        //Assert
        ArgumentCaptor<Participant> participantArgumentCaptor = ArgumentCaptor.forClass(Participant.class);
        Mockito.verify(participantRepo).save(participantArgumentCaptor.capture());
        Participant capturedParticipant = participantArgumentCaptor.getValue();
        assertThat(capturedParticipant).isEqualTo(participant);
    }
    @Test
    void canUpdateParticipant() throws ParticipantNotFoundException {
        //Arrange
        participant.setAffiliation("participant22");
        participant.setEmail("participant22");
        participant.setFirstName("participant22");
        participant.setLastName("participant22");
        participant.setTitle("participant22");
        participant.getId();
        Mockito.when(participantRepo.findById(id)).thenReturn(Optional.ofNullable(participant));
        Mockito.when(participantRepo.save(participant)).thenReturn(participant);
        //Act
        participantService.updateParticipant(id, participant);
        //Assert
        assertThat(participant.getAffiliation()).isEqualTo("participant22");
        assertThat(participant.getEmail()).isEqualTo("participant22");
        assertThat(participant.getFirstName()).isEqualTo("participant22");
        assertThat(participant.getLastName()).isEqualTo("participant22");
        assertThat(participant.getTitle()).isEqualTo("participant22");



    }
    @Test
    void canDeleteParticipant() throws ParticipantNotFoundException {
        participantService.deleteParticipant(id);
        Mockito.verify(participantRepo).deleteById(id);
    }
    @Test
        //can get list of all participants
    void canGetAllParticipants() throws ParticipantNotFoundException {
        participantService.getAllParticipant();
        Mockito.verify(participantRepo).findAll();
    }
    //test search
    @Test
    void canSearchParticipant() throws ParticipantNotFoundException {
        participantService.findByKeyword("participant1");
        Mockito.verify(participantRepo).findByKeyword("participant1");
    }




}
