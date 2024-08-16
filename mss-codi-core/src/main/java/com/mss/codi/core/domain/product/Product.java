package com.mss.codi.core.domain.product;

import com.mss.codi.core.domain.BaseEntity;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.enums.DataStatusType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MSS_PRODUCT")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_TYPE", nullable = false)
    private DataStatusType statusType;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY_TYPE", nullable = false)
    private CategoryType categoryType;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "UPD_USER")
    private String updUser;

    @Builder
    public Product(DataStatusType statusType, String productName, Long brandId, CategoryType categoryType, Long price, String regUser) {
        this.statusType = statusType;
        this.productName = productName;
        this.brandId = brandId;
        this.categoryType = categoryType;
        this.price = price;
        this.regUser = regUser;
        this.updUser = regUser;
    }

    public void updateProduct(String productName, CategoryType categoryType, Long price, String updUser) {
        this.productName = productName;
        this.categoryType = categoryType;
        this.price = price;
        this.updUser = updUser;
    }

    public void deleteProduct(String updUser) {
        this.statusType = DataStatusType.DELETE;
        this.updUser = updUser;
    }
}
