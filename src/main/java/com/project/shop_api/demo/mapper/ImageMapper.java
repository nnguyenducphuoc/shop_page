package com.project.shop_api.demo.mapper;

import com.project.shop_api.demo.dto.response.ImageResponse;
import com.project.shop_api.demo.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageResponse imageToImageResponse(Image image);
}
