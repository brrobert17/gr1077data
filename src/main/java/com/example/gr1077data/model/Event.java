package com.example.gr1077data.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event extends Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    //does JPA know?
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")

    private LocalTime startTime;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")

    private LocalTime endTime;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<ParagraphSection> paragraphSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<LinkSection> linkSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<ImageSection> imageSectionSet;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @ManyToMany()
    @JoinTable(name = "researcher_event_join",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "researcher_id"))
    private Set<Researcher> researcherSet = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "external_researcher_event_join",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "external_researcher_id"))
    private Set<ExternalResearcher> externalResearcherSet = new HashSet<>();

    @OneToMany()
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Set<Participant> participantSet = new HashSet<>();

}
