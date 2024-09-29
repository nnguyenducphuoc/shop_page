package com.project.shop_api.demo.service;

import com.project.shop_api.demo.dto.request.ProductCreateRequest;
import com.project.shop_api.demo.dto.response.ProductDetailResponse;
import com.project.shop_api.demo.dto.response.ProductResponse;
import com.project.shop_api.demo.entity.*;
import com.project.shop_api.demo.exception.AppException;
import com.project.shop_api.demo.exception.ErrorCode;
import com.project.shop_api.demo.helper.MyHelper;
import com.project.shop_api.demo.mapper.*;
import com.project.shop_api.demo.repository.CategoryRepository;
import com.project.shop_api.demo.repository.DiscountRepository;
import com.project.shop_api.demo.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<ProductResponse> filterProducts(int page, int size, String sortBy, String order, String category, String color, String pvSize, String style, Double price) {
        PageRequest pageRequest = this.createPageRequest(page, size, sortBy, order);
        Page<Product> products = productRepository.filterProducts(category, color, pvSize, style, price, pageRequest);
        return products.map(this::mapperToProductResponse);
    }

    public ProductDetailResponse createProduct(ProductCreateRequest productCreateRequest) {

        Category category = categoryRepository.findById(productCreateRequest.getCategoryId())
                .orElseThrow( () -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        Double DEFAULT_RATING = 0.0;
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .imgUrl(productCreateRequest.getImgUrl())
                .originalPrice(productCreateRequest.getOriginalPrice())
                .category(category)
                .rating(DEFAULT_RATING)
                .build();

        Discount discount = new Discount();
        if (productCreateRequest.getDiscountId() != null) {
            discount = discountRepository.findById(productCreateRequest.getDiscountId())
                    .orElseThrow( () -> new AppException(ErrorCode.DISCOUNT_NOT_EXISTED));
            product.setDiscount(discount);
        }

        ProductDetail productDetail = ProductDetail.builder()
                .product(product)
                .description(productCreateRequest.getDescription())
                .build();

        List<Image> images = new ArrayList<>();
        productCreateRequest.getImages().forEach(imageRequest -> {
            Image image = new Image();
            image.setUrl(imageRequest.getUrl());
            image.setProductDetail(productDetail);
            images.add(image);
        });

        List<ProductVariant> productVariants = new ArrayList<>();
        productCreateRequest.getVariants().forEach(productVariantRequest -> {
            ProductVariant productVariant = new ProductVariant();
            productVariant.setColor(productVariantRequest.getColor());
            productVariant.setSize(productVariantRequest.getSize());
            productVariant.setStyle(productVariantRequest.getStyle());
            productVariant.setQuantity(productVariantRequest.getQuantity());
            productVariant.setProductDetail(productDetail);

            productVariants.add(productVariant);
        });

        productRepository.save(product);
        productDetailService.createProductDetail(productDetail);
        images.forEach(imageService::createImage);
        productVariants.forEach(productVariantService::createProductVariant);

        Double price = MyHelper.handlePrice(product.getOriginalPrice(), discount.getValue());



        ProductDetailResponse productDetailResponse = ProductDetailResponse.builder()
                .productId(product.getProductId())
                .category(categoryMapper.categoryToCategoryResponse(category))
                .variants(productVariants.stream().map(productVariantMapper::productVariantToProductVariantResponse).toList())
                .images(images.stream().map(imageMapper::imageToImageResponse).toList())
                .description(productDetail.getDescription())
                .lookedAt(productDetail.getLookedAt())
                .reviewed(productDetail.getReviewed())
                .imgUrl(product.getImgUrl())
                .name(product.getName())
                .price(price)
                .originalPrice(product.getOriginalPrice())
                .rating(productDetail.getProduct().getRating())
                .build();

        if (productCreateRequest.getDiscountId() != null) {
            productDetailResponse.setDiscount(discountMapper.discountToDiscountResponse(discount));
        }
        return  productDetailResponse;
    }

//    public List<ProductResponse> getAllProducts() {
//        return productRepository.findAll().stream()
//                .map(productMapper::productToProductResponse).toList();
//    }

    public Page<ProductResponse> findAllProducts(int page, int size, String sortBy, String order) {
        PageRequest pageRequest = this.createPageRequest(page, size, sortBy, order);
        Page<Product> products = productRepository.findAll(pageRequest);
        return products.map(this::mapperToProductResponse);
    }

    private PageRequest createPageRequest(int page, int size, String sortBy, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return PageRequest.of(page, size, sort);
    }



    private ProductResponse mapperToProductResponse(Product product) {
        ProductResponse productResponse = productMapper.productToProductResponse(product);
        productResponse.setPrice(MyHelper.handlePrice(product.getOriginalPrice(), product.getDiscount().getValue()));
        return productResponse;
    }
}
