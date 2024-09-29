package com.project.shop_api.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailResponse {
    Long productId;
    String name;
    String description;
    int lookedAt;
    int reviewed;
    Double price;
    Double originalPrice;
    String imgUrl;
    Double rating;
    CategoryResponse category;
    DiscountResponse discount;
    List<ImageResponse> images = new ArrayList<>();
    List<ProductVariantResponse> variants = new ArrayList<>();
}
