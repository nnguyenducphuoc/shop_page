package com.project.shop_api.demo.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreateRequest {
    String name;
    Double originalPrice;
    String imgUrl;
    Double rating;
    Long category_id;
    Long discount_id;
}
