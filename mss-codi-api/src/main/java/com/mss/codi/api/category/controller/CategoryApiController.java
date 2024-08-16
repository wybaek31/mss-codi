package com.mss.codi.api.category.controller;

import com.mss.codi.api.category.controller.dto.ProductMinMaxPriceRes;
import com.mss.codi.api.category.facade.CategoryApiFacade;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/api/category")
@Tag(name = "코디 카테고리 API")
public class CategoryApiController {

    private final CategoryApiFacade categoryApiFacade;

    @Operation(summary = "최저, 최고 가격 브랜드와 상품 가격 조회 API",
            description = "최저, 최고 가격 브랜드와 상품 가격 조회를 위한 API 입니다. 파라미터로 카테고리 타입을 전달해주세요."
    )
    @GetMapping("/product/min-max-price")
    public CommonResponse<ProductMinMaxPriceRes> getProductMinMaxPrice(@RequestParam("categoryType") CategoryType categoryType) {
        return CommonResponse.success(categoryApiFacade.getCategoryMinMaxPrice(categoryType));
    }
}
