package com.mss.codi.api.product.facade;

import com.mss.codi.api.product.controller.dto.BrandCategoryMinPricesRes;
import com.mss.codi.api.product.controller.dto.CategoryMinPricesRes;
import com.mss.codi.api.product.service.ProductApiService;
import com.mss.codi.api.product.service.ProductCacheApiService;
import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductApiFacade {

    private final ProductCacheApiService productCacheApiService;
    private final ProductApiService productApiService;

    /**
     * 카테고리별 최저가격 조회 및 총액 계산
     * @return
     */
    public CategoryMinPricesRes getFacadeCategoryMinPrices() {
        List<CategoryMinPriceDto> categoryMinPriceList = null;

        // Step 1. Cache 조회.
        try {
            categoryMinPriceList = productCacheApiService.getCacheCategoryMinPrices();
        } catch (Exception e) {
            // Cache 조회시 에러 발생.
            log.error("[Exception] getCacheCategoryMinPrices : cause = {}", e.getMessage());
        }

        // Step 2. DB 조회.
        if (categoryMinPriceList == null || categoryMinPriceList.isEmpty()) {
            categoryMinPriceList = productApiService.getCategoryMinPrices();
        }

        // 결과 세팅
        long totalPrice = categoryMinPriceList.stream()
                .mapToLong(CategoryMinPriceDto::getPrice)
                .sum();

        return CategoryMinPricesRes.builder()
                .categoryList(categoryMinPriceList)
                .totalPrice(totalPrice)
                .build();
    }

    /**
     * 브랜드 카테고리별 최저가격 조회
     * @return
     */
    public BrandCategoryMinPricesRes getFacadeBrandCategoryMinPrices() {
        List<BrandCategoryMinPriceDto> brandCategoryMinPriceList = null;

        // Step 1. Cache 조회.
        try {
            brandCategoryMinPriceList = productCacheApiService.getCacheBrandCategoryMinPrices();
        } catch (Exception e) {
            // Cache 조회시 에러 발생.
            log.error("[Exception] getCacheBrandCategoryMinPrices : cause = {}", e.getMessage());
        }

        // Step 2. DB 조회.
        if (brandCategoryMinPriceList == null || brandCategoryMinPriceList.isEmpty()) {
            brandCategoryMinPriceList = productApiService.getBrandCategoryMinPrices();
        }

        // 브랜드별로 최저가 상품을 추적
        Map<Long, List<BrandCategoryMinPriceDto>> categoryPrice = new HashMap<>();
        Map<Long, Long> brandTotalPrice = new HashMap<>();

        for (BrandCategoryMinPriceDto brandCategoryMinPriceDto : brandCategoryMinPriceList) {
            Long brandId = brandCategoryMinPriceDto.getBrandId();
            Long price = brandCategoryMinPriceDto.getPrice();

            // 브랜드별 카테고리 정리.
            categoryPrice.computeIfAbsent(brandId, k -> new ArrayList<>())
                    .add(brandCategoryMinPriceDto);

            // 브랜드별 총액 계산.
            brandTotalPrice.put(brandId, brandTotalPrice.getOrDefault(brandId, 0L) + price);
        }

        Long minPriceBrandId = Collections.min(brandTotalPrice.entrySet(), Map.Entry.comparingByValue()).getKey();
        Long totalPrice = brandTotalPrice.get(minPriceBrandId);
        List<BrandCategoryMinPriceDto> categoryList = categoryPrice.get(minPriceBrandId);

        return BrandCategoryMinPricesRes.builder()
                .brandName(categoryList.getFirst().getBrandName())
                .categoryList(categoryList)
                .totalPrice(totalPrice)
                .build();
    }

}
