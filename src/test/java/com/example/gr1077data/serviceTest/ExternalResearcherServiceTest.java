package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.model.Image;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.ExternalResearcherRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.ExternalResearcherService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.ExternalResearcherNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ExternalResearcherServiceTest {

    @Autowired
    BlogPostService blogPostService;
    @Autowired
    BlogPostRepo blogPostRepo;
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    ExternalResearcherRepo externalResearcherRepo;
    @Autowired
    ExternalResearcherService externalResearcherService;

    Image image;
    Image image2;
    ExternalResearcher externalResearcher;
    ExternalResearcher externalResearcher2;
    BlogPost blogPost;
    BlogPost blogPost2;
    BlogPost blogPost3;
    Set<BlogPost> blogPostSet = new HashSet<>();
    Set<BlogPost> blogPostSet2 = new HashSet<>();


    @BeforeEach
    void setUp() {
        image = Image.builder().url("www").caption("ccc").build();
        image2 = Image.builder().url("www2").caption("ccc2").build();

        externalResearcher = ExternalResearcher.builder().
                firstName("rob").lastName("bar").title("mr")
                .email("email").profileImage(image).profileLink("link").build();
        externalResearcher2 = ExternalResearcher.builder().
                firstName("rob2").lastName("bar2").title("mr2").
                email("email2").profileImage(image2).profileLink("link2").build();

        blogPost = BlogPost.builder().title("mm").build();
        blogPost2 = BlogPost.builder().title("kk").build();
        blogPost3 = BlogPost.builder().title("ee").build();

        blogPostSet.add(blogPost);
        blogPostSet.add(blogPost2);
        blogPostSet2.add(blogPost2);
        blogPostSet2.add(blogPost3);

        externalResearcher.setBlogPostSet(blogPostSet);
        externalResearcher2.setBlogPostSet(blogPostSet2);

        blogPostRepo.deleteAll();
        externalResearcherRepo.deleteAll();

        externalResearcherRepo.save(externalResearcher);
        externalResearcherRepo.save(externalResearcher2);
        blogPostRepo.save(blogPost);
        blogPostRepo.save(blogPost2);
        blogPostRepo.save(blogPost3);
        //System.out.println(externalResearcherRepo.findAll());
    }

    @Test
    void addExternalResearcher() throws ExternalResearcherNotFoundException {
        image = Image.builder().url("newww").caption("newwww").build();
        externalResearcher = ExternalResearcher.builder().
                firstName("robo").lastName("baro").title("mro").
                email("emailo").profileImage(image).profileLink("linko").build();
        Long id = externalResearcherService.create(externalResearcher).getId();
        Assertions.assertThat(externalResearcherRepo.findById(id).get().getEmail()).isEqualTo(externalResearcher.getEmail());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(externalResearcherService.getAll()).hasSize(2);
    }

    @Test
    public void testGet() throws ExternalResearcherNotFoundException {
        Assertions.assertThat(externalResearcherService.getById(2L)).isNotNull();
    }

    @Test
    public void testDelete() throws ExternalResearcherNotFoundException {
        List<ExternalResearcher> externalResearchers = externalResearcherRepo.findAll();
        int externalResearcherIndex = externalResearchers.size() - 1;
        ExternalResearcher externalResearcher = externalResearchers.get(externalResearcherIndex);
        Long id = externalResearcher.getId();
        externalResearcherRepo.deleteById(id);
        Assertions.assertThat(externalResearcherRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws BlogPostNotFoundException {
        List<ExternalResearcher> externalResearchers = externalResearcherRepo.findAll();
        int externalResearcherIndex = externalResearchers.size() - 1;
        ExternalResearcher externalResearcher = externalResearchers.get(externalResearcherIndex);
        Long id = externalResearcher.getId();
        externalResearcher.setTitle("updatedTitle");
        externalResearcherRepo.save(externalResearcher);
        Assertions.assertThat(externalResearcherRepo.findById(id).get().getTitle()).isEqualTo("updatedTitle");
    }
}

