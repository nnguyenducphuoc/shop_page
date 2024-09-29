package com.project.shop_api.demo.service;

import com.project.shop_api.demo.entity.Image;
import com.project.shop_api.demo.mapper.ImageMapper;
import com.project.shop_api.demo.repository.ImageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageService {
    ImageRepository imageRepository;
    ImageMapper imageMapper;

    public void createImage(Image image) {
        imageMapper.imageToImageResponse(imageRepository.save(image));
    }
}
