package com.project.shop_api.demo.mapper;

import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.entity.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {

    ProductDetailResponse productDetailToProductDetailResponse(ProductDetail productDetail);
}
