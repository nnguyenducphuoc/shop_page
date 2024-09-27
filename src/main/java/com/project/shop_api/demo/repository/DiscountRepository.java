package com.project.shop_api.demo.repository;

import com.project.shop_api.demo.entity.Discount;
import com.project.shop_api.demo.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
