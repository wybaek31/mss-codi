package com.mss.codi.api.product.controller;

import com.mss.codi.api.product.controller.dto.BrandCategoryMinPricesRes;
import com.mss.codi.api.product.controller.dto.CategoryMinPricesRes;
import com.mss.codi.api.product.facade.ProductApiFacade;
import com.mss.codi.core.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/api/product")
@Tag(name = "코디 상품 API")
public class ProductApiController {

    private final ProductApiFacade productApiFacade;

    @Operation(summary = "카테고리 별 최저가 브랜드, 상품 조회 API",
            description = "카테고리 별 최저가격 브랜드와 상품가격이 조회되고 총액을 구할수 있는 API 입니다."
    )
    @GetMapping("/category/min-prices")
    public CommonResponse<CategoryMinPricesRes> getCategoryMinPrices() {
        return CommonResponse.success(productApiFacade.getFacadeCategoryMinPrices());
    }

    @Operation(summary = "모든 카테고리 구매시 최저가 브랜드 조회 API",
            description = "모든 카테고리의 상품을 구매할때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회는 API 입니다."
    )
    @GetMapping("/brand/category/min-prices")
    public CommonResponse<BrandCategoryMinPricesRes> getBrandCategoryMinPrices() {
        return CommonResponse.success(productApiFacade.getFacadeBrandCategoryMinPrices());
    }
}
