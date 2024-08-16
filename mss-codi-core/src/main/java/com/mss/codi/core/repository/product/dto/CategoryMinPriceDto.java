package com.mss.codi.core.repository.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class CategoryMinPriceDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -5851846800447074369L;

    private String categoryName;
    private String brandName;
    private Long price;

}
