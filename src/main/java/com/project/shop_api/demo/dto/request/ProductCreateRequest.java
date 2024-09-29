package com.project.shop_api.demo.dto.request;

import com.project.shop_api.demo.dto.response.ImageResponse;
import com.project.shop_api.demo.dto.response.ProductVariantResponse;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "Product name cannot be null")
    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
    String name;
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    String description;

    @NotNull(message = "Original price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Original price must be greater than zero")
    Double originalPrice;
    @Pattern(regexp = "^(http|https)://.*$", message = "Image URL must be a valid URL")
    String imgUrl;

        @NotNull(message = "Category ID cannot be null")
    @Positive(message = "Category ID must be greater than zero")
    Long categoryId;
    @Positive(message = "Discount ID must be greater than zero")
    Long discountId;
    List<ImageRequest> images = new ArrayList<>();
    List<ProductVariantRequest> variants = new ArrayList<>();
}
