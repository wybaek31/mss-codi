package com.mss.codi.admin.brand.controller;

import com.mss.codi.admin.brand.controller.dto.RegisterBrandReq;
import com.mss.codi.admin.brand.service.BrandAdminService;
import com.mss.codi.core.domain.brand.BrandInfo;
import com.mss.codi.core.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/admin")
@Tag(name = "브랜드 Admin API")
public class BrandAdminController {

    private final BrandAdminService brandAdminService;

    @Operation(summary = "브랜드 등록 API",
            description = "브랜드 등록 API 입니다. 중복되지 않는 브랜드명을 요청해주세요."
    )
    @PostMapping("/brand")
    public CommonResponse<BrandInfo> registerBrand(@RequestBody @Valid RegisterBrandReq req) {
        return CommonResponse.success(brandAdminService.registerBrand(req));
    }

}
