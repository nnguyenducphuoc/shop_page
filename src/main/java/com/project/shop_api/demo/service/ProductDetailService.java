package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.entity.ProductDetail;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.mapper.CategoryMapper;
import com.project.shop_api.demo.mapper.DiscountMapper;
import com.project.shop_api.demo.mapper.ProductDetailMapper;
import com.project.shop_api.demo.repository.ProductDetailRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductDetailService {
    ProductDetailRepository productDetailRepository;

    CategoryMapper categoryMapper;
    ProductDetailMapper productDetailMapper;
    DiscountMapper discountMapper;




    public ProductDetailResponse createProductDetail(ProductDetail productDetail) {
        return productDetailMapper.productDetailToProductDetailResponse(productDetailRepository.save(productDetail));
    }

    public ProductDetailResponse findProductDetailById(Long id) {
        ProductDetail productDetail = productDetailRepository.findByProductId(id).orElseThrow( () -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        ProductDetailResponse response = productDetailMapper.productDetailToProductDetailResponse(productDetail);
        response.setCategory(categoryMapper.categoryToCategoryResponse(productDetail.getProduct().getCategory()));
        response.setName(productDetail.getProduct().getName());
        response.setImgUrl(productDetail.getProduct().getImgUrl());
        response.setRating(productDetail.getProduct().getRating());
        response.setOriginalPrice(productDetail.getProduct().getOriginalPrice());
        response.setDiscount(discountMapper.discountToDiscountResponse(productDetail.getProduct().getDiscount()));

        return response;
    }
}
