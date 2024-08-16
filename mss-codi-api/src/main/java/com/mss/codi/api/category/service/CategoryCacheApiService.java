package com.mss.codi.api.category.service;

import com.mss.codi.core.constants.CacheProperty;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryCacheApiService {

    private final CategoryApiService categoryApiService;

    @Cacheable(value = CacheProperty.CacheKeys.CATEGORY_PRODUCT_MIN, key = "#p0")
    public CategoryMinPriceDto getCacheCategoryMinPrice(CategoryType categoryType) {
        return categoryApiService.getCategoryMinPrice(categoryType);
    }

    @Cacheable(value = CacheProperty.CacheKeys.CATEGORY_PRODUCT_MAX, key = "#p0")
    public CategoryMinPriceDto getCacheCategoryMaxPrice(CategoryType categoryType) {
        return categoryApiService.getCategoryMaxPrice(categoryType);
    }
}
