package com.example.gr1077data.controller;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.service.BlogPostService;
import com.example.gr1077data.service.exception.ArticleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {

    final BlogPostService articleService;

    @GetMapping
    public List<BlogPost> findAllArticles() {
        return articleService.findAllArticles();
    }

    @GetMapping("{id}")
    public BlogPost findArticleById(@PathVariable Long id) throws ArticleNotFoundException {
        return articleService.findArticleById(id);
    }

    @GetMapping(params = "keyword")
    public BlogPost findArticleByTitle(@RequestParam String title) throws ArticleNotFoundException {
        return articleService.findArticleByTitle(title);
    }

    @PostMapping
    public BlogPost saveArticle(@RequestBody BlogPost article) {
        return articleService.saveArticle(article);
    }

    @DeleteMapping("{id}")
    public BlogPost deleteArticleById(@PathVariable Long id) throws ArticleNotFoundException {
        return articleService.deleteArticleById(id);
    }

    @PutMapping
    public BlogPost updateArticle(@RequestBody BlogPost article) throws ArticleNotFoundException {
        return articleService.updateArticle(article);
    }
}
