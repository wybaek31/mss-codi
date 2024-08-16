package com.mss.codi.api.product.service;

import com.mss.codi.api.product.controller.dto.BrandCategoryMinPricesRes;
import com.mss.codi.api.product.controller.dto.CategoryMinPricesRes;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.ProductRepository;
import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import com.mss.codi.core.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductApiService {

    private final ProductService productService;
    private final ProductRepository productRepository;

    /**
     * 카테고리별 최저가격 조회 및 총액 계산
     * @return
     */
    public CategoryMinPricesRes getCategoryMinPrices() {
        List<CategoryMinPriceDto> categoryMinPriceList = new ArrayList<>();

        // 카테고리별 최저가격 조회.
        for (CategoryType categoryType : CategoryType.values()) {
            CategoryMinPriceDto categoryMinPriceDto = productService.getMinProductByCategoryType(categoryType);
            categoryMinPriceList.add(categoryMinPriceDto);
        }

        // 결과 세팅.
        return CategoryMinPricesRes.builder()
                .categoryList(categoryMinPriceList)
                .totalPrice(categoryMinPriceList.stream().mapToLong(CategoryMinPriceDto::getPrice).sum())
                .build();
    }

    /**
     * 브랜드 카테고리별 최저가격 조회
     * @return
     */
    public BrandCategoryMinPricesRes getBrandCategoryMinPrices() {
        // 브랜드 카테고리별 최저가격 조회.
        List<BrandCategoryMinPriceDto> brandCategoryMinPriceList = productRepository.findBrandIdAndCategoryTypeOrderByPriceAsc(CategoryType.values());

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
