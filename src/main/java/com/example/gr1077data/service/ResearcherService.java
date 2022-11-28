package com.example.gr1077data.service;

import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ResearcherService {

    private final ResearcherRepo researcherRepo;

    private final ImageRepo imageRepo;

    private final BlogPostRepo blogPostRepo;

    private final SectionService<Researcher> sectionService;

    public List<Researcher> findAll() {
        return researcherRepo.findAll();
    }

    public Researcher getById(Long id) throws ResearcherNotFoundException {
        Optional<Researcher> optionalResearcher = researcherRepo.findById(id);
        if (optionalResearcher.isEmpty()) {
            throw new ResearcherNotFoundException("Researcher not found by: " + id);
        }
        return optionalResearcher.get();
    }

    public List<Researcher> findByName(String name) {
        return researcherRepo.findByName(name);
    }

    public Researcher save(Researcher researcher) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(researcher))) throw new SectionsSequenceException("Invalid sections sequence");
        return researcherRepo.save(researcher);
    }

    public void del(Long id) throws ResearcherNotFoundException {
        researcherRepo.findById(id).orElseThrow(()->new ResearcherNotFoundException("Researcher not found by: " + id));
        researcherRepo.deleteById(id);
    }

    public Researcher update(Long id, Researcher researcher) throws ResearcherNotFoundException {
        researcherRepo.findById(id).orElseThrow(()->new ResearcherNotFoundException("Researcher not found by: " + id));
        return researcherRepo.save(researcher);
    }
//   public Researcher checkImageAndArticle(Researcher researcher) {
//        Long imageId = researcher.getProfileImage().getId();
//        ArrayList<Long> blogPostIds = new ArrayList<>();
//        researcher.getBlogPostSet().forEach(
//                blogPost -> {
//                    blogPostIds.add(blogPost.getId());
//                }
//        );
//        if (imageId != null && imageRepo.findById(imageId).isPresent()) {
//            researcher.setProfileImage(imageRepo.findById(imageId).get());
//        }
//        if (!blogPostIds.isEmpty()) {
//            Set<BlogPost> blogPostSet = new HashSet<>();
//            blogPostIds.forEach(
//                    blogPostId -> {
//                        if (blogPostRepo.findById(blogPostId).isPresent()) {
//                            blogPostSet.add(blogPostRepo.findById(blogPostId).get());
//                        }
//                    });
//            researcher.setBlogPostSet(blogPostSet);
//        }
//        return researcher;
//    }
}
