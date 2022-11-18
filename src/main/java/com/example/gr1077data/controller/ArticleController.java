package com.example.gr1077data.controller;

import com.example.gr1077data.model.Article;
import com.example.gr1077data.service.ArticleService;
import com.example.gr1077data.service.exception.ArticleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    final ArticleService articleService;

    @GetMapping
    public List<Article> findAllArticles() {
        return articleService.findAllArticles();
    }

    @GetMapping("/findById")
    public Article findArticleById(@RequestParam Long id) throws ArticleNotFoundException {
        return articleService.findArticleById(id);
    }

    @GetMapping("/findByTitle")
    public Article findArticleByTitle(@RequestParam String title) throws ArticleNotFoundException {
        return articleService.findArticleByTitle(title);
    }

    @PostMapping
    public Article saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @DeleteMapping
    public Article deleteArticleById(@RequestParam Long id) throws ArticleNotFoundException {
        return articleService.deleteArticleById(id);
    }

    @PutMapping
    public Article updateArticle(@RequestBody Article article) throws ArticleNotFoundException {
        return articleService.updateArticle(article);
    }
}
