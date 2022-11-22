package com.example.gr1077data.model;

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
public class Researcher {

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
    //@Column(nullable = false)
    private Image profileImage;


    @ManyToMany
    @JoinTable(name = "researcher_blog_post_join",
            joinColumns = @JoinColumn(name = "researcher_id"),
            inverseJoinColumns = @JoinColumn(name = "blog_post_id"))
    private Set<BlogPost> blogPostSet = new HashSet<>();

}
