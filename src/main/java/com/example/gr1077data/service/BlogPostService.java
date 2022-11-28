package com.example.gr1077data.service;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    final BlogPostRepo blogPostRepo;
    final SectionService<BlogPost> sectionService;

    public List<BlogPost> findAllBlogPosts() {
        return blogPostRepo.findAll();
    }

    public BlogPost findBlogPostById(Long id) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findById(id);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        return optionalBlogPost.get();
    }

    public BlogPost findBlogPostByTitle(String title) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findByTitle(title);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + title);
        }
        return optionalBlogPost.get();
    }

    public BlogPost saveBlogPost(BlogPost blogPost) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(blogPost))) throw new SectionsSequenceException("Invalid sections sequence");
        return blogPostRepo.save(blogPost);
    }

    public BlogPost deleteBlogPostById(Long id) throws BlogPostNotFoundException{
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findById(id);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        blogPostRepo.deleteById(id);
        return optionalBlogPost.get();
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPost) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(blogPost))) throw new SectionsSequenceException("Invalid sections sequence");
        if(blogPostRepo.findById(id).isEmpty()){
            return null;
        }
        return blogPostRepo.save(blogPost);
    }

    // Adam's weird stuff
}
