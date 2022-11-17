package com.example.gr1077data.service;

import com.example.gr1077data.model.Article;
import com.example.gr1077data.repo.ArticleRepo;
import com.example.gr1077data.service.exception.ArticleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    final ArticleRepo articleRepo;

    public List<Article> findAllArticles() {
        return articleRepo.findAll();
    }

    public Article findArticleById(Long id) throws ArticleNotFoundException {
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + id);
        }
        return optionalArticle.get();
    }

    public Article findArticleByTitle(String title) throws ArticleNotFoundException {
        Optional<Article> optionalArticle = articleRepo.findByTitle(title);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + title);
        }
        return optionalArticle.get();
    }

    public Article saveArticle(Article article) {
        articleRepo.save(article);
        return article;
    }

    public Article deleteArticleById(Long id) throws ArticleNotFoundException {
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + id);
        }
        articleRepo.deleteById(id);
        return optionalArticle.get();
    }

    public Article updateArticle(Article article) throws ArticleNotFoundException {
        Article old = findArticleById(article.getId());
        old.setDescription(article.getDescription());
        old.setTitle(article.getTitle());
        articleRepo.save(old);
        return article;
    }
}
