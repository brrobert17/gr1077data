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
@Builder
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private Set<ParagraphSection> paragraphSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private Set<LinkSection> linkSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private Set<ImageSection> imageSectionSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "researcher_blog_post_join",
            joinColumns = @JoinColumn(name = "blog_post_id"),
            inverseJoinColumns = @JoinColumn(name = "researcher_id"))
    private Set<Researcher> researcherSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "external_researcher_blog_post_join",
            joinColumns = @JoinColumn(name = "blog_post_id"),
            inverseJoinColumns = @JoinColumn(name = "external_researcher_id"))
    private Set<ExternalResearcher> externalResearcherSet = new HashSet<>();

}
