package com.project.shop_api.demo.mapper;

import com.project.shop_api.demo.dto.response.DiscountResponse;
import com.project.shop_api.demo.entity.Discount;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountMapper {
    DiscountResponse discountToDiscountResponse(Discount discount);
}
