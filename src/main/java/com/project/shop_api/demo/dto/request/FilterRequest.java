package com.project.shop_api.demo.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilterRequest {
    @Pattern(regexp = "Home & Decor|Clothing|Accessories|Outdoor", message = "Category must be one of: Home & Decor, Clothing, Accessories, Outdoor")
    String category;

    @Pattern(regexp = "Green|Purple|Pink|Black", message = "Color must be one of: Green, Purple, Pink, Black")
     String color;

    @Pattern(regexp = "S|M|L|XL", message = "Product size must be one of: S,M,L,XL")
     String pvSize;

    @Pattern(regexp = "Modern|Streetwear|Colorfull|Patchwork|Bohemian|Vintage", message = "Modern, Streetwear, Colorfull, Patchwork, Bohemian, Vintage")
     String style;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
     Double price;

    @Min(value = 0, message = "Page number cannot be less than 0")
    int page = 0;

    @Min(value = 1, message = "Size must be at least 1")
    int size = 10;

    @Pattern(regexp = "name|originalPrice|rating", message = "Sort by must be one of: name, originalPrice, rating")
    String sortBy = "name";

    @Pattern(regexp = "asc|desc", message = "Sort order must be 'asc' or 'desc'")
    String sort = "asc";
}
