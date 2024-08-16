package com.mss.codi.api.product.controller.dto;

import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BrandCategoryMinPricesRes {
    private String brandName;
    private List<BrandCategoryMinPriceDto> categoryList;
    private Long totalPrice;

    @Builder
    public BrandCategoryMinPricesRes(String brandName, List<BrandCategoryMinPriceDto> categoryList, Long totalPrice) {
        this.brandName = brandName;
        this.categoryList = categoryList;
        this.totalPrice = totalPrice;
    }
}
