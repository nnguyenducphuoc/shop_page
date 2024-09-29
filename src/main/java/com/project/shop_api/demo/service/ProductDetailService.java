package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.entity.Product;
import com.project.shop_api.demo.entity.ProductDetail;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.helper.MyHelper;
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

    public void createProductDetail(ProductDetail productDetail) {
        productDetailMapper.productDetailToProductDetailResponse(productDetailRepository.save(productDetail));
    }

    public ProductDetailResponse findProductDetailByProduct(Long id) {
        Product productRequest = Product.builder().productId(id).build();
        ProductDetail productDetail = productDetailRepository.findProductDetailByProduct(productRequest).orElseThrow( () -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        Product product = productDetail.getProduct();
        ProductDetailResponse response = productDetailMapper.productDetailToProductDetailResponse(productDetail);
        response.setPrice(MyHelper.handlePrice(product.getOriginalPrice(), product.getDiscount().getValue()));
        response.setCategory(categoryMapper.categoryToCategoryResponse(product.getCategory()));
        response.setName(product.getName());
        response.setImgUrl(product.getImgUrl());
        response.setRating(product.getRating());
        response.setOriginalPrice(product.getOriginalPrice());
        response.setDiscount(discountMapper.discountToDiscountResponse(product.getDiscount()));
        response.setProductId(product.getProductId());
        return response;
    }

}
