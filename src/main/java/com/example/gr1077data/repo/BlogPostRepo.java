package com.example.gr1077data.repo;

import com.example.gr1077data.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {

    Optional<BlogPost> findByTitle(String title);
}
