package com.example.gr1077data.model;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
public abstract class Page {


    private Set<ParagraphSection> paragraphSectionSet;

    private Set<LinkSection> linkSectionSet;

    private Set<ImageSection> imageSectionSet;
}
