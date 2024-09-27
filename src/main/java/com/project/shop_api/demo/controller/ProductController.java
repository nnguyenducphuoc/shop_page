package com.project.shop_api.demo.controller;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ApiResponse;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class ProductController {
    ProductService productService;

    @PostMapping
    public ApiResponse<ProductDetailResponse> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Product Created Successfully");
        apiResponse.setResult(productService.createProduct(productCreateRequest));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> createProduct() {
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Get All Product Successfully");
        apiResponse.setResult(productService.getAllProducts());
        return apiResponse;
    }
}
