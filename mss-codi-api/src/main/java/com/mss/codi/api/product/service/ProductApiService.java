package com.mss.codi.api.product.service;

import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.ProductRepository;
import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductApiService {

    private final ProductRepository productRepository;

    /**
     * 카테고리별 최저가격 조회 및 총액 계산
     * @return
     */
    public List<CategoryMinPriceDto> getCategoryMinPrices() {
        List<CategoryMinPriceDto> categoryMinPriceList = new ArrayList<>();

        // 카테고리별 최저가격 조회.
        for (CategoryType categoryType : CategoryType.values()) {
            CategoryMinPriceDto categoryMinPriceDto = productRepository.findCategoryTypeOrderByPriceAsc(categoryType);
            categoryMinPriceList.add(categoryMinPriceDto);
        }

        return categoryMinPriceList;
    }

    /**
     * 브랜드 카테고리별 최저가격 조회
     * @return
     */
    public List<BrandCategoryMinPriceDto> getBrandCategoryMinPrices() {
        return productRepository.findBrandIdAndCategoryTypeOrderByPriceAsc(CategoryType.values());
    }
}
