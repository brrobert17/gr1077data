package com.example.gr1077data.service;

import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResearcherService {

    final ResearcherRepo researcherRepo;

    public List<Researcher> findAllResearchers() {
        return researcherRepo.findAll();
    }

    public Researcher findResearcherById(Long id) throws ResearcherNotFoundException {
        Optional<Researcher> optionalResearcher = researcherRepo.findById(id);
        if (optionalResearcher.isEmpty()) {
            throw new ResearcherNotFoundException("Researcher not found by: " + id);
        }
        return optionalResearcher.get();
    }

    public List<Researcher> findResearchersByName(String name) {
        return researcherRepo.findResearcherByName(name);
    }

    public Researcher saveResearcher(Researcher researcher) {
        return researcherRepo.save(researcher);
    }

    public Researcher deleteResearcherById(Long id) throws ResearcherNotFoundException {
        Optional<Researcher> optionalResearcher = researcherRepo.findById(id);
        if (optionalResearcher.isEmpty()) {
            throw new ResearcherNotFoundException("Researcher not found by: " + id);
        }
        researcherRepo.deleteById(id);
        return optionalResearcher.get();
    }

    public Researcher updateResearcher(Researcher researcher) throws ResearcherNotFoundException {
        Researcher old = findResearcherById(researcher.getId());
        old.setFirstName(researcher.getFirstName());
        old.setLastName(researcher.getLastName());
        old.setTitle(researcher.getTitle());
        old.setCv(researcher.getCv());
        old.setEmail(researcher.getEmail());
        old.setProfile(researcher.getProfile());
        old.setPublications(researcher.getPublications());
        old.setTelephone(researcher.getTelephone());
        old.setArticleSet(researcher.getArticleSet());
        old.setProfileImage(researcher.getProfileImage());
        researcherRepo.save(old);
        return researcher;
    }
}
