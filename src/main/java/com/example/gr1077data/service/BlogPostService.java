package com.example.gr1077data.service;

import com.example.gr1077data.model.*;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.EventNotFoundException;
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

    public List<BlogPost> getAll() {
        return blogPostRepo.findAll();
    }

    public BlogPost findById(Long id) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findById(id);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        return optionalBlogPost.get();
    }

    public BlogPost findByTitle(String title) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findByTitle(title);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + title);
        }
        return optionalBlogPost.get();
    }

    public BlogPost create(BlogPost blogPost) throws SectionsSequenceException {
        if (!(sectionService.isSequenceValid(blogPost)))
            throw new SectionsSequenceException("Invalid sections sequence");
        return blogPostRepo.save(blogPost);
    }

    public BlogPost del(Long id) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findById(id);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        blogPostRepo.deleteById(id);
        return optionalBlogPost.get();
    }

    public BlogPost update(Long id, BlogPost blogPost) throws SectionsSequenceException, BlogPostNotFoundException {
        if (!(sectionService.isSequenceValid(blogPost)))
            throw new SectionsSequenceException("Invalid sections sequence");
        blogPostRepo.findById(id).orElseThrow(() -> new BlogPostNotFoundException("BlogPost not found by: " + id));
        return blogPostRepo.save(blogPost);
    }

}
