package com.mss.codi.api.category.service;

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

    public CategoryMinPriceDto getCategoryMinPrice(CategoryType categoryType) {
        return productRepository.findCategoryTypeOrderByPriceAsc(categoryType);
    }

    public CategoryMinPriceDto getCategoryMaxPrice(CategoryType categoryType) {
        return productRepository.findCategoryTypeOrderByPriceDesc(categoryType);
    }
}
