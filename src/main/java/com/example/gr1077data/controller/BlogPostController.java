package com.example.gr1077data.controller;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {

    final BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> findAllBlogPosts() {
        return new ResponseEntity<>(blogPostService.findAllBlogPosts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogPost> findBlogPostById(@PathVariable Long id) throws BlogPostNotFoundException {
        if(id==null || id <=0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPostService.findBlogPostById(id),HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<BlogPost> findBlogPostByTitle(@RequestParam String title) throws BlogPostNotFoundException {
        return new ResponseEntity<>(blogPostService.findBlogPostByTitle(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BlogPost> saveBlogPost(@RequestBody BlogPost blogPost) {
        return new ResponseEntity<>(blogPostService.saveBlogPost(blogPost),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BlogPost> deleteBlogPostById(@PathVariable Long id) throws BlogPostNotFoundException{
        if(id==null || id <=0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPostService.deleteBlogPostById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        if(id==null || id <=0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPostService.updateBlogPost(id, blogPost), HttpStatus.OK);
    }
}
