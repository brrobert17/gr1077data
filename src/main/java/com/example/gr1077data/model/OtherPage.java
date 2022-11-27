package com.example.gr1077data.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OtherPage extends Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "other_id", referencedColumnName = "id")
    private Set<ParagraphSection> paragraphSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "other_id", referencedColumnName = "id")
    private Set<LinkSection> linkSectionSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "other_id", referencedColumnName = "id")
    private Set<ImageSection> imageSectionSet;
}
