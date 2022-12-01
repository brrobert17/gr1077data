package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.*;
import com.example.gr1077data.service.*;
import com.example.gr1077data.service.exception.EventNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class EventServiceTest {

    @Autowired EventService eventService;
    @Autowired EventRepo eventRepo;
    @Autowired RoomService roomService;
    @Autowired RoomRepo roomRepo;
    @Autowired LocationService locationService;
    @Autowired LocationRepo locationRepo;
    @Autowired ResearcherService researcherService;
    @Autowired ResearcherRepo researcherRepo;
    @Autowired ExternalResearcherService externalResearcherService;
    @Autowired ExternalResearcherRepo externalResearcherRepo;
    @Autowired ParticipantService participantService;
    @Autowired ParticipantRepo participantRepo;
    @Autowired ImageRepo imageRepo;

    Event event;
    Location location;
    Room room;
    Researcher researcher;
    ExternalResearcher externalResearcher;
    Participant participant;
    Image image;
    ParagraphSection paragraphSection;
    ImageSection imageSection;
    LinkSection linkSection;

    Set<Researcher> researcherSet = new HashSet<>();
    Set<ExternalResearcher> externalResearcherSet = new HashSet<>();
    Set<ParagraphSection> paragraphSectionSet = new HashSet<>();
    Set<ImageSection> imageSectionSet = new HashSet<>();
    Set<LinkSection> linkSectionSet = new HashSet<>();

    @BeforeEach
    void setUp(){
        participantRepo.deleteAll();
        eventRepo.deleteAll();
        roomRepo.deleteAll();
        researcherRepo.deleteAll();
        externalResearcherRepo.deleteAll();

        location = Location.builder().address("street1").build();
        locationRepo.save(location);
        room = Room.builder().name("r1").capacity("3").location(location).build();
        roomRepo.save(room);

        image = Image.builder().url("www").caption("ccc").build();
        externalResearcher = ExternalResearcher.builder().
                firstName("rob").lastName("bar").title("mr")
                .email("email").profileImage(image).profileLink("link").build();
        externalResearcherSet.add(externalResearcher);
        externalResearcherRepo.save(externalResearcher);

        image = Image.builder().url("www2").caption("ccc2").build();
        researcher = Researcher.builder().
                firstName("robo").lastName("baro").title("mro").
                cv("cvo").email("emailo").profile("profileo").telephone("9770").
                publications("publicationso").profileImage(image).build();
        researcherSet.add(researcher);
        researcherRepo.save(researcher);

        image = Image.builder().url("www29").caption("ccc29").build();
        paragraphSection = ParagraphSection.builder().heading("hh").build();
        paragraphSectionSet.add(paragraphSection);
        imageSection = ImageSection.builder().altText("txt").image(image).build();
        imageSectionSet.add(imageSection);
        linkSection = LinkSection.builder().link("www.kk").build();
        linkSectionSet.add(linkSection);
        image = Image.builder().url("www27").caption("ccc27").build();
        event = Event.builder().image(image).date(LocalDate.of(2022,12,31))
                .imageSectionSet(imageSectionSet).linkSectionSet(linkSectionSet)
                .paragraphSectionSet(paragraphSectionSet)
                .startTime(LocalTime.of(10,0,0))
                .endTime(LocalTime.of(14,0,0)).room(room)
                .name("event").researcherSet(researcherSet).build();
        eventRepo.save(event);
        participant = Participant.builder().firstName("fName")
                .lastName("lName").email("email").title("title").affiliation("expert")
                .event(event).build();
        participantRepo.save(participant);

        image = Image.builder().url("www23").caption("ccc23").build();
        event = Event.builder().image(image).date(LocalDate.of(2023,12,31))
                .startTime(LocalTime.of(10,0,0))
                .endTime(LocalTime.of(14,0,0))
                .room(room).externalResearcherSet(externalResearcherSet).name("event2").build();
        eventRepo.save(event);
        participant = Participant.builder().firstName("fName2")
                .lastName("lName2").email("email2").title("title2").affiliation("expert2")
                .event(event).build();
        participantRepo.save(participant);

    }

    @Test
    void all() throws EventNotFoundException {
        Assertions.assertThat(eventService.getAll()).hasSize(2).doesNotContainNull();
    }

//    @Test
//    void create() throws EventNotFoundException, SectionsSequenceException {
//
//        image = Image.builder().url("www2e34").caption("ccc2e34").build();
//        event = Event.builder().image(image).date(LocalDate.of(2023,11,3))
//                .startTime(LocalTime.of(10,0,0))
//                .endTime(LocalTime.of(14,0,0))
//                .room(room).researcherSet(researcherSet).name("event24").build();
//        eventService.create(event);
//        participant = Participant.builder().firstName("fName24")
//                .lastName("lName24").email("email24").title("title24").affiliation("expert24")
//                .event(event).build();
//        participantRepo.save(participant);
//        List<Event> events = eventRepo.findAll();
//        int eventIndex = events.size() - 1;
//        Event event = events.get(eventIndex);
//        Long id = event.getId();
//        Assertions.assertThat(eventService.getById(id).getParticipantSet()).isNotNull();
//
//    }
//
//    @Test
//    void update() throws EventNotFoundException, SectionsSequenceException {
//        List<Event> events = eventRepo.findAll();
//        int eventIndex = events.size() - 1;
//        Event event = events.get(eventIndex);
//        Long id = event.getId();
//        event.setName("newEventName");
//        Assertions.assertThat(eventService.update(id, event).getName()).isEqualTo("newEventName");
//    }
//
//    @Test
//    void del() throws EventNotFoundException {
//        List<Event> events = eventRepo.findAll();
//        int eventIndex = events.size() - 1;
//        Event event = events.get(eventIndex);
//        Long id = event.getId();
//        eventService.del(id);
//        Assertions.assertThat(eventRepo.findById(id)).isNotPresent();
//
//    }

}
