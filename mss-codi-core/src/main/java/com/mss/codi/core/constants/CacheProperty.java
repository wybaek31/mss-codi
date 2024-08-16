package com.mss.codi.core.constants;

import lombok.Getter;

@Getter
public enum CacheProperty {
    CACHE_CATEGORY_PRICE(CacheKeys.CATEGORY_PRICE, 60),
    CACHE_BRAND_CATEGORY_PRICE(CacheKeys.BRAND_CATEGORY_PRICE, 60),
    CACHE_CATEGORY_PRODUCT_MIN(CacheKeys.CATEGORY_PRODUCT_MIN, 60),
    CACHE_CATEGORY_PRODUCT_MAX(CacheKeys.CATEGORY_PRODUCT_MAX, 60);

    public final String cacheName;
    public final long expireTime;

    CacheProperty(String cacheName, long expireTime) {
        this.cacheName = cacheName;
        this.expireTime = expireTime;
    }

    public static class CacheKeys {
        public static final String CATEGORY_PRICE = "category:price";
        public static final String BRAND_CATEGORY_PRICE = "brand:category:price";
        public static final String CATEGORY_PRODUCT_MIN = "category:product:min";
        public static final String CATEGORY_PRODUCT_MAX = "category:product:max";
    }
}
