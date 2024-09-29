package com.project.shop_api.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    Long detailId;
    String description;
    int lookedAt;
    int reviewed;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    List<ProductVariant> variants = new ArrayList<>();
    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    List<Image> images = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    Product product;
}
