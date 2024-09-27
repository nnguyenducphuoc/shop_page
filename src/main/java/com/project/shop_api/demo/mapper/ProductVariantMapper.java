package com.project.shop_api.demo.mapper;


import com.project.shop_api.demo.dto.response.ProductVariantResponse;
import com.project.shop_api.demo.entity.ProductVariant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {
    ProductVariantResponse productVariantToProductVariantResponse(ProductVariant productVariant);
}
