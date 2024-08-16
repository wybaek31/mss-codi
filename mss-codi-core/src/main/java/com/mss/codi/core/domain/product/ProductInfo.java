package com.mss.codi.core.domain.product;

import com.mss.codi.core.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductInfo {

    private Long productId;
    private String productName;
    private Long brandId;
    private CategoryType categoryType;
    private Long price;
    private String regUser;
    private String updUser;
    private LocalDateTime regDate;
    private LocalDateTime updDate;
}
