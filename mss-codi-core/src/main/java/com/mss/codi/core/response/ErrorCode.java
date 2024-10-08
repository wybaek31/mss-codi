package com.mss.codi.core.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    COMMON_SYSTEM_ERROR(20000, "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER(20001, "요청한 값이 올바르지 않습니다,"),

    BRAND_ALREADY_EXIST(30001, "이미 등록된 브랜드명입니다."),
    BRAND_NOT_FOUND(30002, "브랜드 정보가 없습니다."),
    PRODUCT_PRICE_ZERO(30003, "상품 가격은 0보다 커야 합니다."),
    PRODUCT_NOT_FOUND(30004, "상품 정보가 없습니다."),
    ;

    @Getter
    private final int errorCode;
    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
