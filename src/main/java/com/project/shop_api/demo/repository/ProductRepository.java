package com.project.shop_api.demo.repository;

import com.project.shop_api.demo.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p " +
            "JOIN Category c ON p.category.categoryId = c.categoryId " +
            "JOIN Discount d ON p.discount.discountId = d.discountId " +
            "JOIN ProductDetail pd ON p.productId = pd.product.productId " +
            "JOIN ProductVariant pv ON pd.detailId = pv.productDetail.detailId " +
            "WHERE (:category IS NULL OR c.name LIKE %:category%) " +
            "AND (:color IS NULL OR pv.color = :color) " +
            "AND (:pvSize IS NULL OR pv.size = :pvSize) " +
            "AND (:style IS NULL OR pv.style = :style) " +
            "AND (:price IS NULL OR (p.originalPrice - (p.originalPrice * d.value/100)) < :price)")
    Page<Product> filterProducts(String category, String color, String pvSize, String style, Double price, Pageable pageable);
}
