package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.entity.Category;
import com.project.shop_api.demo.entity.Discount;
import com.project.shop_api.demo.entity.Product;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.mapper.ProductMapper;
import com.project.shop_api.demo.repository.CategoryRepository;
import com.project.shop_api.demo.repository.DiscountRepository;
import com.project.shop_api.demo.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    DiscountRepository discountRepository;
    CategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductCreateRequest productCreateRequest) {

        // Product product = productMapper.productCreateRequestToProduct(productCreateRequest);
        Discount discount = discountRepository.findById(productCreateRequest.getDiscount_id())
                .orElseThrow( () -> new AppException(ErrorCode.DISCOUNT_NOT_EXISTED));
        Category category = categoryRepository.findById(productCreateRequest.getCategory_id())
                .orElseThrow( () -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .imgUrl(productCreateRequest.getImgUrl())
                .originalPrice(productCreateRequest.getOriginalPrice())
                .discount(discount)
                .category(category)
                .rating(productCreateRequest.getRating())
                .build();
        return  productMapper.productToProductResponse(productRepository.save(product));
    }
}
