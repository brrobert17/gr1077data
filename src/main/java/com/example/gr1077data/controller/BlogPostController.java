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
    public void deleteBlogPostById(@PathVariable Long id) {
        blogPostService.deleteBlogPostById(id);
    }

    @PutMapping("{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        return blogPostService.updateBlogPost(id, blogPost);
    }
}
