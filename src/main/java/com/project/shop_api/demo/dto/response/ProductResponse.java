package com.project.shop_api.demo.dto.response;

import com.project.shop_api.demo.entity.Category;
import com.project.shop_api.demo.entity.Discount;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    Double originalPrice;
    String imgUrl;
    Double rating;
    Category category;
    Discount discount;
}
