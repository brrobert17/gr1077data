package com.example.gr1077data.service;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.EventRepo;
import com.example.gr1077data.repo.OtherPageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionService {

    public boolean isSequenceValid(BlogPost post) {
        List<Integer> sequence = new ArrayList<Integer>();

        sequence.addAll(
                post.getLinkSectionSet().stream()
                        .map(LinkSection::getSeq)
                        .collect(Collectors.toList())
        );
        sequence.addAll(
                post.getImageSectionSet().stream()
                        .map(ImageSection::getSeq)
                        .collect(Collectors.toList())
        );
        sequence.addAll(
                post.getParagraphSectionSet().stream()
                        .map(ParagraphSection::getSeq)
                        .collect(Collectors.toList())
        );

        Set<Integer> sequenceSet = new HashSet<>(sequence);

        return sequenceSet.size() == sequence.size();

    }
}
