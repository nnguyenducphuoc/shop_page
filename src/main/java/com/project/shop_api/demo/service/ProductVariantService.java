package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.response.ProductVariantResponse;
import com.project.shop_api.demo.entity.ProductVariant;
import com.project.shop_api.demo.mapper.ProductVariantMapper;
import com.project.shop_api.demo.repository.ProductVariantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductVariantService {
    ProductVariantMapper productVariantMapper;
    ProductVariantRepository productVariantRepository;

    public ProductVariantResponse createProductVariant(ProductVariant productVariant) {
        return productVariantMapper.productVariantToProductVariantResponse(productVariantRepository.save(productVariant));
    }
}
