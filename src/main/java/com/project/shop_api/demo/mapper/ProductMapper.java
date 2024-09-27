package com.project.shop_api.demo.mapper;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // Product productCreateRequestToProduct(ProductCreateRequest productCreateRequest);

    ProductResponse productToProductResponse(Product product);
}
