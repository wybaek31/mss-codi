package com.mss.codi.admin.product.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProductReq {
    @NotBlank(message = "regUser 은/는 필수입니다.")
    private String regUser;
}
