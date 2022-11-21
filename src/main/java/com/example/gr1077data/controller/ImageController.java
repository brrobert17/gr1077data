package com.example.gr1077data.controller;

import com.example.gr1077data.model.Image;
import com.example.gr1077data.service.ImageService;
import com.example.gr1077data.service.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    final ImageService imageService;

    @GetMapping
    public List<Image> findAllImages() {
        return imageService.findAllImages();
    }

    @GetMapping("{id}")
    public Image findImageById(@PathVariable Long id) throws ImageNotFoundException {
        return imageService.findImageById(id);
    }

    @GetMapping(params = "caption")
    public Image findImageByCaption(@RequestParam String caption) throws ImageNotFoundException {
        return imageService.findImageByCaption(caption);
    }

    @PostMapping
    public Image saveImage(@RequestBody Image image) {
        return imageService.saveImage(image);
    }

    @DeleteMapping("{id}")
    public Image deleteImageById(@PathVariable Long id) throws ImageNotFoundException {
        return imageService.deleteImageById(id);
    }

    @PutMapping
    public Image updateImage(@RequestBody Image image) throws ImageNotFoundException {
        return imageService.updateImage(image);
    }
}
