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
public class BlogPostServiceTest {
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
    Image image3;
    Image image4;
    Researcher researcher;
    Researcher researcher2;
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
        image3 = Image.builder().url("www3").caption("ccc3").build();
        image4 = Image.builder().url("www4").caption("ccc4").build();

        researcher = Researcher.builder().
                firstName("rob").lastName("bar").title("mr").
                cv("cv").email("email").profile("profile").telephone("977").
                publications("publications").profileImage(image).build();
        researcher2 = Researcher.builder().
                firstName("rob2").lastName("bar2").title("mr2").
                cv("cv2").email("email2").profile("profile2").telephone("9772").
                publications("publications2").profileImage(image2).build();

        externalResearcher = ExternalResearcher.builder().
                firstName("dan").lastName("sza").title("mr").email("email").
                profileLink("profileLink").profileImage(image3).build();
        externalResearcher2 = ExternalResearcher.builder().
                firstName("dan2").lastName("sza2").title("mr2").email("email2").
                profileLink("profileLink2").profileImage(image4).build();

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
        externalResearcher.setBlogPostSet(blogPostSet2);

        blogPostRepo.deleteAll();
        researcherRepo.deleteAll();
        externalResearcherRepo.deleteAll();

        researcherRepo.save(researcher);
        researcherRepo.save(researcher2);
        externalResearcherRepo.save(externalResearcher);
        externalResearcherRepo.save(externalResearcher2);
        blogPostRepo.save(blogPost);
        blogPostRepo.save(blogPost2);
        blogPostRepo.save(blogPost3);
        System.out.println(blogPostRepo.findAll());
    }

    @Test
    void addBlogPost() throws BlogPostNotFoundException, SectionsSequenceException {
        BlogPost blogPost = BlogPost.builder().title("mmNew").
                /*description("hhhNew").*/build();
        blogPostService.saveBlogPost(blogPost);
        BlogPost blogPost1 = blogPostService.findBlogPostByTitle("mmNew");
        Assertions.assertThat(blogPost1.getTitle()).isEqualTo(blogPost.getTitle());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(blogPostService.findAllBlogPosts()).hasSize(3);
    }

    @Test
    public void testGet() throws BlogPostNotFoundException {
        Assertions.assertThat(blogPostService.findBlogPostById(5L)).isNotNull();
    }

    @Test
    public void testDelete() throws BlogPostNotFoundException {
        List<BlogPost> blogPosts = blogPostRepo.findAll();
        int blogPostIndex = blogPosts.size() - 1;
        BlogPost blogPost1 = blogPosts.get(blogPostIndex);
        Long id = blogPost1.getId();
        blogPostService.deleteBlogPostById(id);
        Assertions.assertThat(blogPostRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws BlogPostNotFoundException {
        List<BlogPost> blogPosts = blogPostRepo.findAll();
        int blogPostIndex = blogPosts.size() - 1;
        BlogPost blogPost1 = blogPosts.get(blogPostIndex);
        Long id = blogPost1.getId();
        blogPost1.setTitle("updatedTitle");
        blogPostRepo.save(blogPost1);
        Assertions.assertThat(blogPostService.findBlogPostByTitle("updatedTitle")).isNotNull();
    }
}
