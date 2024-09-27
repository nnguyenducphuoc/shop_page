package com.project.shop_api.demo.mapper;

import com.project.shop_api.demo.dto.response.CategoryResponse;
import com.project.shop_api.demo.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryResponse categoryToCategoryResponse(Category category);
}
