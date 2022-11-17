package com.example.gr1077data.repo;

import com.example.gr1077data.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
