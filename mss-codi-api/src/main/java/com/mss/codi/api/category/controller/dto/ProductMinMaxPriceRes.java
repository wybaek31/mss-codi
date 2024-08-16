package com.mss.codi.api.category.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ProductMinMaxPriceRes {
    private ProductMinMaxPriceInfo minPriceProduct;
    private ProductMinMaxPriceInfo maxPriceProduct;

    @Getter
    @Setter
    public static class ProductMinMaxPriceInfo {
        private String brandName;
        private Long price;
    }
}
