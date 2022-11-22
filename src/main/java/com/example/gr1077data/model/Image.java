package com.example.gr1077data.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String url;

    @Column(nullable = false, length = 500)
    private String caption;





}
