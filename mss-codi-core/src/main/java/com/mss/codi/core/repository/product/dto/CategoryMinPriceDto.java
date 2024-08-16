package com.mss.codi.core.repository.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryMinPriceDto {
    private String categoryName;
    private String brandName;
    private Long price;

}
