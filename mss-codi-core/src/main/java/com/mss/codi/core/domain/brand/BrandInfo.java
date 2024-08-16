package com.mss.codi.core.domain.brand;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandInfo {
    private Long brandId;
    private String brandName;
}
