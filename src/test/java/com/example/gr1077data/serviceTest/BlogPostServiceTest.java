package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.repo.ExternalResearcherRepo;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.repo.ResearcherRepo;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
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
    Researcher researcher;
    ExternalResearcher externalResearcher;
    BlogPost blogPost;
    Set<BlogPost> blogPostSet = new HashSet<>();
    ParagraphSection paragraphSection;
    ImageSection imageSection;
    LinkSection linkSection;

    Set<Researcher> researcherSet = new HashSet<>();
    Set<ExternalResearcher> externalResearcherSet = new HashSet<>();
    Set<ParagraphSection> paragraphSectionSet = new HashSet<>();
    Set<ImageSection> imageSectionSet = new HashSet<>();
    Set<LinkSection> linkSectionSet = new HashSet<>();


    @BeforeEach
    void setUp() {
        blogPostRepo.deleteAll();
        researcherRepo.deleteAll();
        externalResearcherRepo.deleteAll();

        paragraphSection = ParagraphSection.builder().heading("hh").build();
        paragraphSectionSet.add(paragraphSection);
        image = Image.builder().url("www29").caption("ccc29").build();
        imageSection = ImageSection.builder().altText("txt").image(image).build();
        imageSectionSet.add(imageSection);
        linkSection = LinkSection.builder().link("www.kk").build();
        linkSectionSet.add(linkSection);

        image = Image.builder().url("www").caption("ccc").build();
        researcher = Researcher.builder().
                firstName("rob").lastName("bar").title("mr").
                cv("cv").email("email").profile("profile").telephone("977").
                publications("publications").profileImage(image).build();
        researcherSet.add(researcher);

        image = Image.builder().url("www2").caption("ccc2").build();
        externalResearcher = ExternalResearcher.builder().
                firstName("dan").lastName("sza").title("mr").email("email").
                profileLink("profileLink").profileImage(image).build();
        externalResearcherSet.add(externalResearcher);

        blogPost = BlogPost.builder().title("mm").researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet).imageSectionSet(imageSectionSet)
                .linkSectionSet(linkSectionSet).paragraphSectionSet(paragraphSectionSet).build();

        researcherRepo.save(researcher);
        externalResearcherRepo.save(externalResearcher);
        blogPostRepo.save(blogPost);
    }

    @Test
    void addBlogPost() throws BlogPostNotFoundException, SectionsSequenceException {
        BlogPost blogPost = BlogPost.builder().title("mmNew").build();
        blogPostService.create(blogPost);
        BlogPost blogPost1 = blogPostService.findByTitle("mmNew");
        Assertions.assertThat(blogPost1.getTitle()).isEqualTo(blogPost.getTitle());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(blogPostService.getAll()).hasSize(1);
    }

    @Test
    public void testGet() throws BlogPostNotFoundException {
        Assertions.assertThat(blogPostService.findById(3L)).isNotNull();
    }

    @Test
    public void testDelete() throws BlogPostNotFoundException {
        List<BlogPost> blogPosts = blogPostRepo.findAll();
        int blogPostIndex = blogPosts.size() - 1;
        BlogPost blogPost1 = blogPosts.get(blogPostIndex);
        Long id = blogPost1.getId();
        blogPostService.del(id);
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
        Assertions.assertThat(blogPostService.findByTitle("updatedTitle")).isNotNull();
    }
}
