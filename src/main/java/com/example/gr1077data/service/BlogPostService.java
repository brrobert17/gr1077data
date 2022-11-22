package com.example.gr1077data.service;

import com.example.gr1077data.model.BlogPost;
import com.example.gr1077data.repo.BlogPostRepo;
import com.example.gr1077data.service.exception.ArticleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    final BlogPostRepo articleRepo;

    public List<BlogPost> findAllArticles() {
        return articleRepo.findAll();
    }

    public BlogPost findArticleById(Long id) throws ArticleNotFoundException {
        Optional<BlogPost> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + id);
        }
        return optionalArticle.get();
    }

    public BlogPost findArticleByTitle(String title) throws ArticleNotFoundException {
        Optional<BlogPost> optionalArticle = articleRepo.findByTitle(title);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + title);
        }
        return optionalArticle.get();
    }

    public BlogPost saveArticle(BlogPost article) {
        articleRepo.save(article);
        return article;
    }

    public BlogPost deleteArticleById(Long id) throws ArticleNotFoundException {
        Optional<BlogPost> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ArticleNotFoundException("Article not found by: " + id);
        }
        articleRepo.deleteById(id);
        return optionalArticle.get();
    }

    public BlogPost updateArticle(BlogPost article) throws ArticleNotFoundException {
        BlogPost old = findArticleById(article.getId());
        old.setDescription(article.getDescription());
        old.setTitle(article.getTitle());
        articleRepo.save(old);
        return article;
    }
}
