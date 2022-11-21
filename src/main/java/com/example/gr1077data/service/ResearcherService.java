package com.example.gr1077data.service;

import com.example.gr1077data.model.Article;
import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.repo.ArticleRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ResearcherService {

    final ResearcherRepo researcherRepo;
    final ImageRepo imageRepo;
    final ArticleRepo articleRepo;

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
        Researcher checkedResearcher = checkImageAndArticle(researcher);
        return researcherRepo.save(checkedResearcher);
    }

    public Researcher deleteResearcherById(Long id) throws ResearcherNotFoundException {
        Optional<Researcher> optionalResearcher = researcherRepo.findById(id);
        if (optionalResearcher.isEmpty()) {
            throw new ResearcherNotFoundException("Researcher not found by: " + id);
        }
        researcherRepo.deleteResearcherByIdCustom(id);
        return optionalResearcher.get();
    }

    public Researcher updateResearcher(Researcher researcher) throws ResearcherNotFoundException {
        Researcher old = findResearcherById(researcher.getId());
        Researcher checkedResearcher = checkImageAndArticle(researcher);
        old.setFirstName(checkedResearcher.getFirstName());
        old.setLastName(checkedResearcher.getLastName());
        old.setTitle(checkedResearcher.getTitle());
        old.setCv(checkedResearcher.getCv());
        old.setEmail(checkedResearcher.getEmail());
        old.setProfile(checkedResearcher.getProfile());
        old.setPublications(checkedResearcher.getPublications());
        old.setTelephone(checkedResearcher.getTelephone());
        old.setArticleSet(checkedResearcher.getArticleSet());
        old.setProfileImage(checkedResearcher.getProfileImage());
        researcherRepo.save(old);
        return researcher;
    }

    public Researcher checkImageAndArticle(Researcher researcher) {
        Long imageId = researcher.getProfileImage().getId();
        ArrayList<Long> articleIds = new ArrayList<>();
        researcher.getArticleSet().forEach(
                article -> {
                    articleIds.add(article.getId());
                }
        );
        if (imageId != null && imageRepo.findById(imageId).isPresent()) {
            researcher.setProfileImage(imageRepo.findById(imageId).get());
        }
        if (!articleIds.isEmpty()) {
            Set<Article> articleSet = new HashSet<>();
            articleIds.forEach(
                    articleId -> {
                        if (articleRepo.findById(articleId).isPresent()) {
                            articleSet.add(articleRepo.findById(articleId).get());
                        }
                    });
            researcher.setArticleSet(articleSet);
        }
        return researcher;
    }
}
