package com.example.gr1077data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
    private Set<Room> roomSet= new HashSet<>();


}
