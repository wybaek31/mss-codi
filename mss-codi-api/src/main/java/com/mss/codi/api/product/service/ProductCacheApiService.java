package com.mss.codi.api.product.service;

import com.mss.codi.core.constants.CacheProperty;
import com.mss.codi.core.repository.product.dto.BrandCategoryPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductCacheApiService {

    private final ProductApiService productApiService;

    @Cacheable(value = CacheProperty.CacheKeys.CATEGORY_PRICE)
    public List<CategoryPriceDto> getCacheCategoryMinPrices() {
        return productApiService.getCategoryMinPrices();
    }

    @Cacheable(value = CacheProperty.CacheKeys.BRAND_CATEGORY_PRICE)
    public List<BrandCategoryPriceDto> getCacheBrandCategoryMinPrices() {
        return productApiService.getBrandCategoryMinPrices();
    }
}
