package com.example.gr1077data.controller;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {

    final BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> findAllBlogPosts() {
        return blogPostService.findAllBlogPosts();
    }

    @GetMapping("{id}")
    public BlogPost findBlogPostById(@PathVariable Long id) throws BlogPostNotFoundException {
        return blogPostService.findBlogPostById(id);
    }

    @GetMapping(params = "keyword")
    public BlogPost findBlogPostByTitle(@RequestParam String title) throws BlogPostNotFoundException {
        return blogPostService.findBlogPostByTitle(title);
    }

    @PostMapping
    public BlogPost saveBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @DeleteMapping("{id}")
    public BlogPost deleteBlogPostById(@PathVariable Long id) throws BlogPostNotFoundException {
        return blogPostService.deleteBlogPostById(id);
    }

    @PutMapping
    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.updateBlogPost(blogPost);
    }
}
