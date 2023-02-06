package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.*;
import com.example.gr1077data.service.ParticipantService;
import com.example.gr1077data.service.exception.ParticipantNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ParticipantServiceTest {

    @Autowired
    ParticipantService participantService;
    @Autowired
    ParticipantRepo participantRepo;

    Participant participant;

    @BeforeEach
    void setUp() {
        participantRepo.deleteAll();
        participant = Participant.builder().firstName("fName")
                .lastName("lName").email("email").title("title").affiliation("expert")
                .build();
        participantRepo.save(participant);
        participant = Participant.builder().firstName("fName2")
                .lastName("lName2").email("email2").title("title2").affiliation("expert2")
                .build();
        participantRepo.save(participant);
    }

    @Test
    void addParticipant() throws ParticipantNotFoundException {
        participant = Participant.builder().firstName("fName3")
                .lastName("lName3").email("email3").title("title3").affiliation("expert3")
                .build();
        Long id = participantService.createNullEvent(participant).getId();
        Assertions.assertThat(participantRepo.findById(id).get().getAffiliation()).isEqualTo(participant.getAffiliation());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(participantService.getAll()).hasSize(2);
    }

    @Test
    public void testGet() throws ParticipantNotFoundException {
        Assertions.assertThat(participantService.getById(2L)).isNotNull();
    }

    @Test
    public void testDelete() throws ParticipantNotFoundException {
        List<Participant> participants = participantRepo.findAll();
        int participantIndex = participants.size() - 1;
        Participant participant = participants.get(participantIndex);
        Long id = participant.getId();
        participantRepo.deleteById(id);
        Assertions.assertThat(participantRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws ParticipantNotFoundException {
        List<Participant> participants = participantRepo.findAll();
        int participantIndex = participants.size() - 1;
        Participant participant = participants.get(participantIndex);
        Long id = participant.getId();
        participant.setTitle("updatedTitle");
        participantRepo.save(participant);
        Assertions.assertThat(participantRepo.findById(id).get().getTitle()).isEqualTo("updatedTitle");
    }
}
