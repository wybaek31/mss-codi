package com.mss.codi.api.product.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class BrandCategoryMinPricesRes {
    private String brandName;
    private List<BrandCategoryMinPricesInfo> categoryList;
    private Long totalPrice;

    @Builder
    public BrandCategoryMinPricesRes(String brandName, List<BrandCategoryMinPricesInfo> categoryList, Long totalPrice) {
        this.brandName = brandName;
        this.categoryList = categoryList;
        this.totalPrice = totalPrice;
    }

    @Getter
    @Setter
    public static class BrandCategoryMinPricesInfo {
        private String categoryName;
        private Long price;
    }
}
