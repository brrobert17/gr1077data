package com.example.gr1077data.serviceTest;

import com.example.gr1077data.model.Image;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.service.ImageService;
import com.example.gr1077data.service.exception.ImageNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ImageServiceTest {
    @Autowired
    ImageService imageService;
    @Autowired
    ImageRepo imageRepo;

    @BeforeEach
    void setUp() {
        Image image = new Image();
        image = Image.builder().url("www").caption("ccc").build();
        imageRepo.deleteAll();
        imageRepo.save(image);
    }

    @Test
    void addImage() throws ImageNotFoundException {
        Image newImage = new Image();
        newImage = Image.builder().url("www2").caption("ccc2").build();
        imageService.create(newImage);
        Image image1 = imageService.findByCaption("caption");
        Assertions.assertThat(image1.getUrl()).isEqualTo(newImage.getUrl());
    }


    @Test
    public void testListAll() {
        Iterable<Image> images = imageService.findAll();
        Assertions.assertThat(images).hasSizeGreaterThan(0);
        for (Image image : images
        ) {
            System.out.println(images);
        }
    }

    @Test
    public void testUpdate() throws ImageNotFoundException {
        List<Image> images = imageService.findAll();
        int imageIndex = images.size() - 1;
        Image image1 = images.get(imageIndex);
        image1.setCaption("newCaption");
        imageRepo.save(image1);
        System.out.println(imageService.findByCaption("newCaption"));
        Assertions.assertThat(imageService.findByCaption("newCaption")).isNotNull();
    }

    @Test
    public void testGet() throws ImageNotFoundException {
        Assertions.assertThat(imageService.findById(1L)).isNotNull();
    }

    @Test
    public void testDelete() {
        List<Image> images = imageService.findAll();
        int imageIndex = images.size() - 1;
        Image image1 = images.get(imageIndex);
        Long id = image1.getId();
        imageRepo.deleteById(id);
        Assertions.assertThat(imageRepo.findById(id)).isNotPresent();
    }
}
