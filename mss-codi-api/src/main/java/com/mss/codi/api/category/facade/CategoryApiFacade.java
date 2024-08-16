package com.mss.codi.api.category.facade;

import com.mss.codi.api.category.controller.dto.ProductMinMaxPriceRes;
import com.mss.codi.api.category.mapper.CategoryApiObjectMapper;
import com.mss.codi.api.category.service.CategoryApiService;
import com.mss.codi.api.category.service.CategoryCacheApiService;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.CategoryPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryApiFacade {

    private final CategoryCacheApiService categoryCacheApiService;
    private final CategoryApiService categoryApiService;
    private final CategoryApiObjectMapper categoryApiObjectMapper;

    public ProductMinMaxPriceRes getCategoryMinMaxPrice(CategoryType categoryType) {
        // Step 1. Cache에서 조회
        CategoryPriceDto minProduct = null;
        CategoryPriceDto maxProduct = null;
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

        // Step 3. 결과 세팅.
        return ProductMinMaxPriceRes.builder()
                .minPriceProduct(categoryApiObjectMapper.toProductMinMaxPriceInfo(minProduct))
                .maxPriceProduct(categoryApiObjectMapper.toProductMinMaxPriceInfo(maxProduct))
                .build();
    }
}
