package com.example.gr1077data.service;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.repo.ExternalResearcherRepo;
import com.example.gr1077data.service.exception.ExternalResearcherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExternalResearcherService {

    private final ExternalResearcherRepo externalResearcherRepo;

    public List<ExternalResearcher> getAll() {
        return externalResearcherRepo.findAll();
    }

    public ExternalResearcher getById(Long id) throws ExternalResearcherNotFoundException {
        return externalResearcherRepo.findById(id).orElseThrow(() -> new ExternalResearcherNotFoundException("External researcher not found by: " + id));
    }

    public ExternalResearcher create(ExternalResearcher externalResearcher) {
        return externalResearcherRepo.save(externalResearcher);
    }

    public ExternalResearcher del(Long id) throws ExternalResearcherNotFoundException {
        ExternalResearcher externalResearcher = externalResearcherRepo.findById(id).orElseThrow(() -> new ExternalResearcherNotFoundException("External researcher not found by: " + id));
        externalResearcherRepo.delete(externalResearcher);
        return externalResearcher;
    }

    public ExternalResearcher update(Long id, ExternalResearcher externalResearcher) throws ExternalResearcherNotFoundException{
        externalResearcherRepo.findById(id).orElseThrow(()-> new ExternalResearcherNotFoundException("External researcher not found by: " + id));
        return externalResearcherRepo.save(externalResearcher);
    }

}


