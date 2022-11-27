package com.example.gr1077data.service;


import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.model.OtherPage;
import com.example.gr1077data.repo.OtherPageRepo;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherPageService {

    private final SectionService<OtherPage> sectionService;

    private final OtherPageRepo otherPageRepo;

    @Autowired
    public OtherPageService(SectionService<OtherPage> sectionService, OtherPageRepo otherPageRepo) {
        this.sectionService = sectionService;
        this.otherPageRepo = otherPageRepo;
    }

    public List<OtherPage> getAll() {
        return otherPageRepo.findAll();
    }

    public OtherPage getById(Long id) throws BlogPostNotFoundException {
        Optional<OtherPage> optionalPage = otherPageRepo.findById(id);
        if (optionalPage.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        return optionalPage.get();
    }

    public OtherPage save(OtherPage otherPage) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(otherPage))) throw new SectionsSequenceException("Invalid sections sequence");
        return otherPageRepo.save(otherPage);
    }

    public OtherPage deleteById(Long id) throws BlogPostNotFoundException {
        Optional<OtherPage> optionalPage = otherPageRepo.findById(id);
        if (optionalPage.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        otherPageRepo.deleteById(id);
        return optionalPage.get();
    }

    public OtherPage update(Long id, OtherPage otherPage) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(otherPage))) throw new SectionsSequenceException("Invalid sections sequence");
        if(otherPageRepo.findById(id).isEmpty()){
            return null;
        }
        return otherPageRepo.save(otherPage);
    }
}
