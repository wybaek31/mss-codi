package com.mss.codi.api.category.facade;

import com.mss.codi.api.category.controller.dto.ProductMinMaxPriceRes;
import com.mss.codi.api.category.service.CategoryApiService;
import com.mss.codi.api.category.service.CategoryCacheApiService;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryApiFacade {

    private final CategoryCacheApiService categoryCacheApiService;
    private final CategoryApiService categoryApiService;

    public ProductMinMaxPriceRes getCategoryMinMaxPrice(CategoryType categoryType) {
        // Step 1. Cache에서 조회
        CategoryMinPriceDto minProduct = null;
        CategoryMinPriceDto maxProduct = null;
        try {
            minProduct = categoryCacheApiService.getCacheCategoryMinPrice(categoryType);
            maxProduct = categoryCacheApiService.getCacheCategoryMaxPrice(categoryType);
        } catch (Exception e) {
            log.error("[Exception] Cache : cause = {}", e.getMessage());
        }

        // Step 2. DB에서 조회
        if (minProduct == null) {
            minProduct = categoryApiService.getCategoryMinPrice(categoryType);
        }
        if (maxProduct == null) {
            maxProduct = categoryApiService.getCategoryMaxPrice(categoryType);
        }

        return ProductMinMaxPriceRes.builder()
                .minPriceProduct(minProduct)
                .maxPriceProduct(maxProduct)
                .build();
    }
}
