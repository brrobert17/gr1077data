package com.example.gr1077data.controller;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.exception.BlogPostNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAll() {
        return new ResponseEntity<>(blogPostService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogPost> getById(@PathVariable Long id) throws BlogPostNotFoundException {
        if(id==null || id <=0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPostService.findById(id),HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<BlogPost> getByTitle(@RequestParam String title) throws BlogPostNotFoundException {
        return new ResponseEntity<>(blogPostService.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BlogPost> save(@RequestBody BlogPost blogPost) throws SectionsSequenceException {
        return new ResponseEntity<>(blogPostService.create(blogPost),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> del(@PathVariable Long id) throws BlogPostNotFoundException{
        if(id==null || id <=0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        blogPostService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BlogPost> update(@PathVariable Long id, @RequestBody BlogPost blogPost)
            throws SectionsSequenceException, BlogPostNotFoundException {
        if(id == null || id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPostService.update(id, blogPost), HttpStatus.OK);
    }
}
