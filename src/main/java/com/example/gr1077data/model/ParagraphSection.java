package com.example.gr1077data.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "paragraph_section")
public class ParagraphSection extends Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private int seq;

    @Column
    private String heading;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

}
