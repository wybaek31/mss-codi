package com.mss.codi.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataStatusType {
    USE("사용"),
    DELETE("삭제");

    private final String description;
}
