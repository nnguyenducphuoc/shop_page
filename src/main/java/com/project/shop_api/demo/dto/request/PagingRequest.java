package com.project.shop_api.demo.dto.request;

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
public class PagingRequest {
    @Min(value = 0, message = "Page number cannot be less than 0")
    int page = 0;

    @Min(value = 1, message = "Size must be at least 1")
    int size = 10;

    @Pattern(regexp = "name|originalPrice|rating", message = "Sort by must be one of: name, originalPrice, rating")
    String sortBy = "name";

    @Pattern(regexp = "asc|desc", message = "Sort order must be 'asc' or 'desc'")
    String sort = "asc";
}
