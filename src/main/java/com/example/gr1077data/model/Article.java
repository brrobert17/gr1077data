package com.example.gr1077data.model;

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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @ManyToMany(mappedBy = "articleSet")
    @JsonIgnore
    private Set<ExternalResearcher> externalResearcherSet = new HashSet<>();
    @ManyToMany(mappedBy = "articleSet")
    @JsonIgnore
    private Set<Researcher> researcherSet = new HashSet<>();




}
