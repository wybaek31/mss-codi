package com.mss.codi.admin.brand.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterBrandReq {

    @NotBlank(message = "brandName 은/는 필수입니다.")
    private String brandName;

    @NotBlank(message = "regUser 은/는 필수입니다.")
    private String regUser;
}
