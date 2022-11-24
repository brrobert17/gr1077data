package com.example.gr1077data.service;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class ResearcherService {

    private final ResearcherRepo researcherRepo;

    private final ImageRepo imageRepo;

    private final BlogPostRepo blogPostRepo;

    @Autowired
    public ResearcherService(ResearcherRepo researcherRepo, ImageRepo imageRepo, BlogPostRepo blogPostRepo) {
        this.researcherRepo = researcherRepo;
        this.imageRepo = imageRepo;
        this.blogPostRepo = blogPostRepo;
    }

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
        //Researcher checkedResearcher = checkImageAndArticle(researcher);
        return researcherRepo.save(researcher);
    }

    public void deleteResearcherById(Long id) throws ResearcherNotFoundException {
        if(researcherRepo.findById(id).isPresent()) {
            researcherRepo.deleteById(id);
        }
    }

    public Researcher updateResearcher(Long id, Researcher researcher) throws ResearcherNotFoundException {
        if (researcherRepo.findById(id).isEmpty()) {
            return null;
        }
        //Researcher checkedResearcher = checkImageAndArticle(researcher);
        return researcherRepo.save(researcher);
    }

   public Researcher checkImageAndArticle(Researcher researcher) {
        Long imageId = researcher.getProfileImage().getId();
        ArrayList<Long> blogPostIds = new ArrayList<>();
        researcher.getBlogPostSet().forEach(
                blogPost -> {
                    blogPostIds.add(blogPost.getId());
                }
        );
        if (imageId != null && imageRepo.findById(imageId).isPresent()) {
            researcher.setProfileImage(imageRepo.findById(imageId).get());
        }
        if (!blogPostIds.isEmpty()) {
            Set<BlogPost> blogPostSet = new HashSet<>();
            blogPostIds.forEach(
                    blogPostId -> {
                        if (blogPostRepo.findById(blogPostId).isPresent()) {
                            blogPostSet.add(blogPostRepo.findById(blogPostId).get());
                        }
                    });
            researcher.setBlogPostSet(blogPostSet);
        }
        return researcher;
    }
}
