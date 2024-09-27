package com.project.shop_api.demo.controller;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ApiResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class ProductController {
    ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Product Created Successfully");
        apiResponse.setResult(productService.createProduct(productCreateRequest));
        return apiResponse;
    }
}
