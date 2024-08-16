package com.mss.codi.core.repository.product.dto;

import com.mss.codi.core.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BrandCategoryMinPriceDto {
    private Long brandId;
    private String brandName;
    private CategoryType categoryType;
    private Long price;
}
