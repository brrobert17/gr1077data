package com.example.gr1077data.repo;

import com.example.gr1077data.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

    Optional<Image> findImageByCaption(String caption);
}
