package com.mss.codi.core.repository.product.dto;

import com.mss.codi.core.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class BrandCategoryPriceDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 539074117232518214L;
    private Long brandId;
    private String brandName;
    private CategoryType categoryType;
    private Long price;
}
