package com.project.shop_api.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    Long imageId;
    String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id", referencedColumnName = "detail_id")
    ProductDetail productDetail;
}
