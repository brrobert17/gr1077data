package com.example.gr1077data.service;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.repo.ExternalResearcherRepo;
import com.example.gr1077data.service.exception.ExternalResearcherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalResearcherService {
    private final ExternalResearcherRepo externalResearcherRepo;
    @Autowired
    public ExternalResearcherService(ExternalResearcherRepo externalResearcherRepo) {
        this.externalResearcherRepo = externalResearcherRepo;
    }
    //get all external researchers

    public List <ExternalResearcher> getAllExternalResearches() throws ExternalResearcherException {
        List<ExternalResearcher> externalResearcherList = externalResearcherRepo.findAll();
        return externalResearcherList;
    }
    public ExternalResearcher getExternalResearchById(Long id) throws ExternalResearcherException {
        ExternalResearcher externalResearcher = externalResearcherRepo.findById(id).orElseThrow(() -> new ExternalResearcherException("External researcher not found by: " + id));
        return externalResearcher;
    }
    public ExternalResearcher createExternalResearch(ExternalResearcher externalResearcher) throws ExternalResearcherException {
        ExternalResearcher newExternalResearcher = externalResearcherRepo.save(externalResearcher);
        return newExternalResearcher;
    }
    public ExternalResearcher deleteExternalResearch(Long id) throws ExternalResearcherException {
        ExternalResearcher externalResearcher = externalResearcherRepo.findById(id).orElseThrow(() -> new ExternalResearcherException("External researcher not found by: " + id));
        externalResearcherRepo.delete(externalResearcher);
        return externalResearcher;
    }
    //update external researcher
    public ExternalResearcher updateExternalResearch(Long id,ExternalResearcher externalResearcher){
       if(externalResearcherRepo.findById(id).isEmpty()){
           return null;

       }
       return externalResearcherRepo.save(externalResearcher);
    }

    }


