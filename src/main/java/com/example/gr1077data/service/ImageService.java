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

    public List<Image> findAllImages() {
        return imageRepo.findAll();
    }

    public Image findImageById(Long id) throws ImageNotFoundException {
        Optional<Image> optionalImage = imageRepo.findById(id);
        if (optionalImage.isEmpty()) {
            throw new ImageNotFoundException("Image not found by: " + id);
        }
        return optionalImage.get();
    }

    public Image findImageByCaption(String caption) throws ImageNotFoundException {
        Optional<Image> optionalImage = imageRepo.findImageByCaption(caption);
        if (optionalImage.isEmpty()) {
            throw new ImageNotFoundException("Image not found by: " + caption);
        }
        return optionalImage.get();
    }

    public Image saveImage(Image image) {
        return imageRepo.save(image);
    }

    public void deleteImageById(Long id) throws ImageNotFoundException {
        imageRepo.deleteById(id);
    }

    public Image updateImage(Long id, Image image) throws ImageNotFoundException {
        if(imageRepo.findById(id).isEmpty()) {
            return null;
        }
        return imageRepo.save(image);
    }
}
