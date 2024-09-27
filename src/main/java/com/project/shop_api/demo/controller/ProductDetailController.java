package com.project.shop_api.demo.controller;

import com.project.shop_api.demo.dto.response.ApiResponse;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.service.ProductDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products/detail")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class ProductDetailController {
    ProductDetailService productDetailService;

    @GetMapping("/{id}")
    public ApiResponse<ProductDetailResponse> getProductDetail(@PathVariable Long id) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Get product detail successful");
        apiResponse.setResult(productDetailService.findProductDetailById(id));
        return apiResponse;
    }
}
