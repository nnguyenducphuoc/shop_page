package com.project.shop_api.demo.controller;

import com.project.shop_api.demo.dto.request.FilterRequest;
import com.project.shop_api.demo.dto.request.PagingRequest;
import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ApiResponse;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class ProductController {
    ProductService productService;

    @GetMapping("/filter")
    public ApiResponse<Page<ProductResponse>> filterProducts(
            @Valid @ModelAttribute FilterRequest filterRequest
    ) {
        if (this.checkFilterRequest(filterRequest)) {
            throw new AppException(ErrorCode.INVALID_REQUEST_PARAM);
        }
        ApiResponse<Page<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Filter Product Successfully");
        apiResponse.setResult(productService.filterProducts(filterRequest));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<ProductDetailResponse> createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Product Created Successfully");
        apiResponse.setResult(productService.createProduct(productCreateRequest));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAllProduct(
            @Valid @ModelAttribute PagingRequest pagingRequest
    ) {
        ApiResponse<Page<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Get All Product Successfully");
        apiResponse.setResult(productService.findAllProducts(pagingRequest));
        return apiResponse;
    }

    private Boolean checkFilterRequest(FilterRequest filterRequest) {
        return filterRequest.getCategory() == null && filterRequest.getPrice() == null &&
        filterRequest.getStyle() == null && filterRequest.getColor() == null && filterRequest.getPvSize() == null;
    }
}
