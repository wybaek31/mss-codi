package com.mss.codi.admin.product.controller.dto;

import com.mss.codi.core.annotation.EnumPattern;
import com.mss.codi.core.enums.CategoryType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductReq {
    @NotBlank(message = "productName 은/는 필수입니다.")
    private String productName;
    @EnumPattern(enumClass = CategoryType.class, message = "CategoryType 을 확인해 주세요.")
    private String categoryType;
    private Long price;
    @NotBlank(message = "regUser 은/는 필수입니다.")
    private String regUser;
}
