package com.project.shop_api.demo.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageRequest {
    @Pattern(regexp = "^(http|https)://.*$", message = "Image URL must be a valid URL")
    String url;
}
