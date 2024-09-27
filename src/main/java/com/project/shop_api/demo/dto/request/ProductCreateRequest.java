package com.project.shop_api.demo.dto.request;

import com.project.shop_api.demo.dto.response.ImageResponse;
import com.project.shop_api.demo.dto.response.ProductVariantResponse;
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
public class ProductCreateRequest {
    String name;
    String description;
    Double originalPrice;
    String imgUrl;
    Long category_id;
    Long discount_id;
    List<ImageRequest> imageRequests = new ArrayList<>();
    List<ProductVariantRequest> productVariantRequests = new ArrayList<>();
}
