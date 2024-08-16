package com.mss.codi.admin.product.controller;

import com.mss.codi.admin.product.controller.dto.DeleteProductReq;
import com.mss.codi.admin.product.controller.dto.RegisterProductReq;
import com.mss.codi.admin.product.controller.dto.UpdateProductReq;
import com.mss.codi.admin.product.service.ProductAdminService;
import com.mss.codi.core.domain.product.ProductInfo;
import com.mss.codi.core.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/admin")
@Tag(name = "상품 Admin API")
public class ProductAdminController {

    private final ProductAdminService productAdminService;

    @Operation(summary = "상품 등록 API",
            description = "상품 등록 API 입니다."
    )
    @PostMapping("/product")
    public CommonResponse<ProductInfo> registerBrand(@RequestBody @Valid RegisterProductReq req) {
        return CommonResponse.success(productAdminService.registerProduct(req));
    }

    @Operation(summary = "상품 수정 API",
            description = "상품 수정 API 입니다."
    )
    @PatchMapping("/product/{productId}")
    public CommonResponse<ProductInfo> updateBrand(@PathVariable("productId") Long productId, @RequestBody @Valid UpdateProductReq req) {
        return CommonResponse.success(productAdminService.updateProduct(productId, req));
    }

    @Operation(summary = "상품 삭제 API",
            description = "상품 삭제 API 입니다."
    )
    @DeleteMapping("/product/{productId}")
    public CommonResponse<String> deleteBrand(@PathVariable("productId") Long productId, @RequestBody @Valid DeleteProductReq req) {
        return CommonResponse.success(productAdminService.deleteProduct(productId, req));
    }
}
