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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String address;

    @OneToMany( mappedBy = "location",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Room> roomSet = new HashSet<>();


}
