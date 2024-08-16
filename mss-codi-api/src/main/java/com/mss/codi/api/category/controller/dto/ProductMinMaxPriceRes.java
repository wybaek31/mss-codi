package com.mss.codi.api.category.controller.dto;

import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductMinMaxPriceRes {
    private CategoryMinPriceDto minPriceProduct;
    private CategoryMinPriceDto maxPriceProduct;
}
