package com.mss.codi.core.repository.product;

import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;

import java.util.List;

public interface ProductQueryRepository {

    // 카테고리별 최저가 상품 조회.
    CategoryMinPriceDto findCategoryTypeOrderByPriceAsc(CategoryType categoryType);

    // 카테고리별 최고가 상품 조회.
    CategoryMinPriceDto findCategoryTypeOrderByPriceDesc(CategoryType categoryType);

    // 브랜드 카테고리별 최저가 상품 조회.
    List<BrandCategoryMinPriceDto> findBrandIdAndCategoryTypeOrderByPriceAsc(CategoryType[] categories);

}
