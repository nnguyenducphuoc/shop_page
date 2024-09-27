package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.entity.*;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.mapper.*;
import com.project.shop_api.demo.repository.CategoryRepository;
import com.project.shop_api.demo.repository.DiscountRepository;
import com.project.shop_api.demo.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductDetailService productDetailService;
    ImageService imageService;
    ProductVariantService productVariantService;

    ProductRepository productRepository;
    DiscountRepository discountRepository;
    CategoryRepository categoryRepository;

    ProductMapper productMapper;
    CategoryMapper categoryMapper;
    DiscountMapper discountMapper;
    ProductVariantMapper productVariantMapper;
    ImageMapper imageMapper;

    public ProductDetailResponse createProduct(ProductCreateRequest productCreateRequest) {

        Discount discount = discountRepository.findById(productCreateRequest.getDiscount_id())
                .orElseThrow( () -> new AppException(ErrorCode.DISCOUNT_NOT_EXISTED));
        Category category = categoryRepository.findById(productCreateRequest.getCategory_id())
                .orElseThrow( () -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        double DEFAULT_RATING = 0.0;
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .imgUrl(productCreateRequest.getImgUrl())
                .originalPrice(productCreateRequest.getOriginalPrice())
                .discount(discount)
                .category(category)
                .rating(DEFAULT_RATING)
                .build();

        int DEFAULT_QUANTITY = 0;
        ProductDetail productDetail = ProductDetail.builder()
                .product(product)
                .reviewed(DEFAULT_QUANTITY)
                .description(productCreateRequest.getDescription())
                .lookedAt(DEFAULT_QUANTITY)
                .build();

        List<Image> images = new ArrayList<>();
        productCreateRequest.getImageRequests().forEach(imageRequest -> {
            Image image = new Image();
            image.setUrl(imageRequest.getUrl());
            image.setProductDetail(productDetail);
            images.add(image);
        });

        List<ProductVariant> productVariants = new ArrayList<>();
        productCreateRequest.getProductVariantRequests().forEach(productVariantRequest -> {
            ProductVariant productVariant = new ProductVariant();
            productVariant.setColor(productVariantRequest.getColor());
            productVariant.setSize(productVariantRequest.getColor());
            productVariant.setStyle(productVariantRequest.getColor());
            productVariant.setProductDetail(productDetail);
            productVariants.add(productVariant);
        });

        productRepository.save(product);
        productDetailService.createProductDetail(productDetail);
        images.forEach(imageService::createImage);
        productVariants.forEach(productVariantService::createProductVariant);


        ProductDetailResponse productDetailResponse = ProductDetailResponse.builder()
                .id(product.getId())
                .category(categoryMapper.categoryToCategoryResponse(category))
                .variants(productVariants.stream().map(productVariantMapper::productVariantToProductVariantResponse).toList())
                .images(images.stream().map(imageMapper::imageToImageResponse).toList())
                .description(productDetail.getDescription())
                .lookedAt(productDetail.getLookedAt())
                .reviewed(productDetail.getReviewed())
                .discount(discountMapper.discountToDiscountResponse(discount))
                .imgUrl(product.getImgUrl())
                .name(product.getName())
                .originalPrice(product.getOriginalPrice())
                .rating(product.getRating())
                .build();

        return productDetailResponse;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::productToProductResponse).toList();
    }


}
