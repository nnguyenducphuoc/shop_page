package com.project.shop_api.demo.controller;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ApiResponse;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class ProductController {
    ProductService productService;

    @GetMapping("/filter")
    public ApiResponse<Page<ProductResponse>> filterProducts(
            @RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number cannot be less than 0") int page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be at least 1") int size,
            @RequestParam(defaultValue = "name") @Pattern(regexp = "name|rating|price", message = "Sort by must be one of: name, price, rating") String sortBy,
            @RequestParam(defaultValue = "asc") @Pattern(regexp = "asc|desc", message = "Sort order must be 'asc' or 'desc'") String sortOrder,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String pvSize,
            @RequestParam(required = false) String style,
            @RequestParam(required = false) Double price
    ) {
        ApiResponse<Page<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Get All Product Successfully");
        apiResponse.setResult(productService.filterProducts(page, size, sortBy, sortOrder, category, color, pvSize, style, price));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<ProductDetailResponse> createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Product Created Successfully");
        apiResponse.setResult(productService.createProduct(productCreateRequest));
        return apiResponse;
    }

//    @GetMapping
//    public ApiResponse<List<ProductResponse>> getAllProduct() {
//        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
//        apiResponse.setMessage("Get All Product Successfully");
//        apiResponse.setResult(productService.getAllProducts());
//        return apiResponse;
//    }

    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAllProduct(
            @RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number cannot be less than 0") int page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be at least 1") int size,
            @RequestParam(defaultValue = "name") @Pattern(regexp = "name|rating|price", message = "Sort by must be one of: name, price, rating") String sortBy,
            @RequestParam(defaultValue = "asc") @Pattern(regexp = "asc|desc", message = "Sort order must be 'asc' or 'desc'") String sortOrder
    ) {
        ApiResponse<Page<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Get All Product Successfully");
        apiResponse.setResult(productService.findAllProducts(page, size, sortBy, sortOrder));
        return apiResponse;
    }


}
