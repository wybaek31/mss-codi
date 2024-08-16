package com.mss.codi.api.category.service;

import com.mss.codi.api.category.controller.dto.ProductMinMaxPriceRes;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.ProductRepository;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryApiService {

    private final ProductRepository productRepository;

    public ProductMinMaxPriceRes getCategoryMinMaxPrices(CategoryType categoryType) {
//        CategoryType categoryType = CategoryType.valueOf(category);

        CategoryMinPriceDto minProduct = productRepository.findCategoryTypeOrderByPriceAsc(categoryType);
        CategoryMinPriceDto maxProduct = productRepository.findCategoryTypeOrderByPriceDesc(categoryType);

        return ProductMinMaxPriceRes.builder()
                .minPriceProduct(minProduct)
                .maxPriceProduct(maxProduct)
                .build();
    }
}
