package com.mss.codi.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private T data;
    private int errorCode;
    private String message;

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> fail(int errorCode, String message) {
        return CommonResponse.<T>builder()
                .result(Result.FAIL)
                .errorCode(errorCode)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode) {
        return CommonResponse.<T>builder()
                .result(Result.FAIL)
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getErrorMsg())
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
