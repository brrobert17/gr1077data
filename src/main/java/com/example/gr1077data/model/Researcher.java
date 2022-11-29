package com.example.gr1077data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Researcher extends Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String telephone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profile;

    @Column(columnDefinition = "TEXT")
    private String cv;

    @Column(columnDefinition = "TEXT")
    private String publications;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image profileImage;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "researcher_id", referencedColumnName = "id")
    private Set<ParagraphSection> paragraphSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "researcher_id", referencedColumnName = "id")
    private Set<LinkSection> linkSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "researcher_id", referencedColumnName = "id")
    private Set<ImageSection> imageSectionSet;

    @ManyToMany(mappedBy = "researcherSet", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<BlogPost> blogPostSet = new HashSet<>();
}
