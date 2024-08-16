package com.mss.codi.api.product.controller.dto;

import com.mss.codi.core.repository.product.dto.CategoryPriceDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryMinPricesRes {
    private List<CategoryPriceDto> categoryList;
    private Long totalPrice;

    @Builder
    public CategoryMinPricesRes(List<CategoryPriceDto> categoryList, Long totalPrice) {
        this.categoryList = categoryList;
        this.totalPrice = totalPrice;
    }
}
