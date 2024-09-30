package com.project.shop_api.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductIdObjectRequest {
    @NotNull(message = "Product ID cannot be null")
    @Positive(message = "Product ID must be greater than zero")
    Long id;
}
