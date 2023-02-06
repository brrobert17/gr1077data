package com.example.gr1077data.service;

import com.example.gr1077data.model.Image;
import com.example.gr1077data.repo.ImageRepo;
import com.example.gr1077data.service.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    final ImageRepo imageRepo;

    public List<Image> findAll() {
        return imageRepo.findAll();
    }

    public Image findById(Long id) throws ImageNotFoundException {
        Optional<Image> optionalImage = imageRepo.findById(id);
        if (optionalImage.isEmpty()) {
            throw new ImageNotFoundException("Image not found by: " + id);
        }
        return optionalImage.get();
    }

    public Image findByCaption(String caption) throws ImageNotFoundException {
        Optional<Image> optionalImage = imageRepo.findImageByCaption(caption);
        if (optionalImage.isEmpty()) {
            throw new ImageNotFoundException("Image not found by: " + caption);
        }
        return optionalImage.get();
    }

    public Image create(Image image) {
        return imageRepo.save(image);
    }

    public void del(Long id) throws ImageNotFoundException {
        imageRepo.findById(id).orElseThrow(()-> new ImageNotFoundException("Image not found by id: " + id));
        imageRepo.deleteById(id);
    }

    public Image update(Long id, Image image) throws ImageNotFoundException {
        imageRepo.findById(id).orElseThrow(()-> new ImageNotFoundException("Image not found by id: " + id));
        return imageRepo.save(image);
    }
}
