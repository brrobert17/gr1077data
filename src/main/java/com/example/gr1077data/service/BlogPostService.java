package com.example.gr1077data.service;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    final BlogPostRepo blogPostRepo;

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

    public BlogPost saveBlogPost(BlogPost blogPost) {
        blogPostRepo.save(blogPost);
        return blogPost;
    }

    public BlogPost deleteBlogPostById(Long id) throws BlogPostNotFoundException {
        Optional<BlogPost> optionalBlogPost = blogPostRepo.findById(id);
        if (optionalBlogPost.isEmpty()) {
            throw new BlogPostNotFoundException("BlogPost not found by: " + id);
        }
        blogPostRepo.deleteById(id);
        return optionalBlogPost.get();
    }

    public BlogPost updateBlogPost(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
    }
}
