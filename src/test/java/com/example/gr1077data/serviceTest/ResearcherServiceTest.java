package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.model.Image;
import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.ExternalResearcherRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ResearcherServiceTest {

    @Autowired
    BlogPostService blogPostService;
    @Autowired
    BlogPostRepo blogPostRepo;
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    ResearcherRepo researcherRepo;
    @Autowired
    ResearcherService researcherService;
    @Autowired
    ExternalResearcherRepo externalResearcherRepo;
    Image image;
    Image image2;
    Researcher researcher;
    Researcher researcher2;
    BlogPost blogPost;
    BlogPost blogPost2;
    BlogPost blogPost3;
    Set<BlogPost> blogPostSet = new HashSet<>();
    Set<BlogPost> blogPostSet2 = new HashSet<>();


    @BeforeEach
    void setUp() {
        image = Image.builder().url("www").caption("ccc").build();
        image2 = Image.builder().url("www2").caption("ccc2").build();

        researcher = Researcher.builder().
                firstName("rob").lastName("bar").title("mr").
                cv("cv").email("email").profile("profile").telephone("977").
                publications("publications").profileImage(image).build();
        researcher2 = Researcher.builder().
                firstName("rob2").lastName("bar2").title("mr2").
                cv("cv2").email("email2").profile("profile2").telephone("9772").
                publications("publications2").profileImage(image2).build();

        /*blogPost = BlogPost.builder().title("mm").
                description("hhh").build();
        blogPost2 = BlogPost.builder().title("kk").
                description("jjj").build();
        blogPost3 = BlogPost.builder().title("ee").description("rrr").build();*/

        blogPostSet.add(blogPost);
        blogPostSet.add(blogPost2);
        blogPostSet2.add(blogPost2);
        blogPostSet2.add(blogPost3);

        researcher.setBlogPostSet(blogPostSet);
        researcher2.setBlogPostSet(blogPostSet2);

        blogPostRepo.deleteAll();
        researcherRepo.deleteAll();

        researcherRepo.save(researcher);
        researcherRepo.save(researcher2);
        blogPostRepo.save(blogPost);
        blogPostRepo.save(blogPost2);
        blogPostRepo.save(blogPost3);
        //System.out.println(researcherRepo.findAll());
    }

    @Test
    void addResearcher() throws ResearcherNotFoundException, SectionsSequenceException {
        image = Image.builder().url("newww").caption("newwww").build();
        researcher = Researcher.builder().
                firstName("robo").lastName("baro").title("mro").
                cv("cvo").email("emailo").profile("profileo").telephone("9770").
                publications("publicationso").profileImage(image).build();
        Long id = researcherService.saveResearcher(researcher).getId();
        Assertions.assertThat(researcherRepo.findById(id).get().getProfile()).isEqualTo(researcher.getProfile());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(researcherService.findAllResearchers()).hasSize(2);
    }

    @Test
    public void testGet() throws ResearcherNotFoundException {
        Assertions.assertThat(researcherService.findResearcherById(2L)).isNotNull();
    }

    @Test
    public void testDelete() throws ResearcherNotFoundException {
        List<Researcher> researchers = researcherRepo.findAll();
        int researcherIndex = researchers.size() - 1;
        Researcher researcher = researchers.get(researcherIndex);
        Long id = researcher.getId();
        researcherRepo.deleteById(id);
        Assertions.assertThat(researcherRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws BlogPostNotFoundException {
        List<Researcher> researchers = researcherRepo.findAll();
        int researcherIndex = researchers.size() - 1;
        Researcher researcher = researchers.get(researcherIndex);
        Long id = researcher.getId();
        researcher.setTitle("updatedTitle");
        researcherRepo.save(researcher);
        Assertions.assertThat(researcherRepo.findById(id).get().getTitle()).isEqualTo("updatedTitle");
        }
}
