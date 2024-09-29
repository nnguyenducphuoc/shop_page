package com.project.shop_api.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    Long productId;
    String name;
    Double originalPrice;
    Double price;
    String imgUrl;
    Double rating;
    DiscountResponse discount;
    CategoryResponse category;
}
