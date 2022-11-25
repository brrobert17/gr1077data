package com.example.gr1077data.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event {

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
    private LocalDateTime dateTime;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<ParagraphSection> paragraphSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<LinkSection> linkSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<ImageSection> imageSectionSet;


    @OneToOne()
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @ManyToMany()
    @JoinTable(name = "researcher_event_join",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "researcher_id"))
    //let's see if the new hashSet makes any difference
    private Set<Researcher> researcherSet = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "external_researcher_event_join",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "external_researcher_id"))
    //let's see if the new hashSet makes any difference
    private Set<ExternalResearcher> externalResearcherSet = new HashSet<>();
    

    //do we need referencedColumnName?
    @OneToMany()
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Set<Participant> participantSet = new HashSet<>();

}
