package com.mss.codi.core.repository.product;

import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.BrandCategoryPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryPriceDto;

import java.util.List;

public interface ProductQueryRepository {

    // 카테고리별 최저가 상품 조회.
    CategoryPriceDto findCategoryTypeOrderByPriceAsc(CategoryType categoryType);

    // 카테고리별 최고가 상품 조회.
    CategoryPriceDto findCategoryTypeOrderByPriceDesc(CategoryType categoryType);

    // 브랜드 카테고리별 최저가 상품 조회.
    List<BrandCategoryPriceDto> findBrandIdAndCategoryTypeOrderByPriceAsc(CategoryType[] categories);

}
