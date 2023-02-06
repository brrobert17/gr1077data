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
    public List<Image> findAll() {
        return imageService.findAll();
    }

    @GetMapping("{id}")
    public Image findById(@PathVariable Long id) throws ImageNotFoundException {
        return imageService.findById(id);
    }

    @GetMapping(params = "caption")
    public Image findByCaption(@RequestParam String caption) throws ImageNotFoundException {
        return imageService.findByCaption(caption);
    }

    @PostMapping
    public Image save(@RequestBody Image image) {
        return imageService.create(image);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Long id) throws ImageNotFoundException {
        imageService.del(id);
    }

    @PutMapping("{id}")
    public Image update(@PathVariable Long id,@RequestBody Image image) throws ImageNotFoundException {
        return imageService.update(id, image);
    }
}
