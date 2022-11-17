package com.example.gr1077data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Data
    public class Participant {

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

        @Column(nullable = false, length = 255)
        private String affiliation;








    }

