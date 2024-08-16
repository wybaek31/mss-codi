package com.mss.codi.core.domain.brand;

import com.mss.codi.core.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MSS_BRAND")
public class Brand extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "BRAND_NAME", nullable = false, unique = true)
    private String brandName;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "UPD_USER")
    private String updUser;

    @Builder
    public Brand(String brandName, String regUser) {
        this.brandName = brandName;
        this.regUser = regUser;
        this.updUser = regUser;
    }
}
