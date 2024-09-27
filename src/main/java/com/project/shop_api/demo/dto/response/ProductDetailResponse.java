package com.project.shop_api.demo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailResponse {
    Long id;
    String name;
    String description;
    int lookedAt;
    int reviewed;
    Double originalPrice;
    String imgUrl;
    Double rating;
    CategoryResponse category;
    DiscountResponse discount;
    List<ImageResponse> images = new ArrayList<>();
    List<ProductVariantResponse> variants = new ArrayList<>();
}
