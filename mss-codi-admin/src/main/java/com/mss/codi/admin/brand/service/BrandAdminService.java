package com.mss.codi.admin.brand.service;

import com.mss.codi.admin.brand.controller.dto.RegisterBrandReq;
import com.mss.codi.core.domain.brand.Brand;
import com.mss.codi.core.domain.brand.BrandInfo;
import com.mss.codi.core.exception.BaseException;
import com.mss.codi.core.mapper.brand.BrandObjectMapper;
import com.mss.codi.core.repository.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.mss.codi.core.response.ErrorCode.BRAND_ALREADY_EXIST;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrandAdminService {

    private final BrandRepository brandRepository;
    private final BrandObjectMapper brandObjectMapper;

    /**
     * 브랜드 등록.
     * @param req
     * @return
     */
    @Transactional
    public BrandInfo registerBrand(RegisterBrandReq req) {
        // Step 1. 중복 브랜드명 조회.
        Brand existBrand = brandRepository.findByBrandName(req.getBrandName());
        if (existBrand != null) {
            log.error("이미 등록된 브랜드명입니다. brandName: {}", req.getBrandName());
            throw new BaseException(BRAND_ALREADY_EXIST);
        }

        // Step 2. 브랜드 등록.
        Brand brand = Brand.builder()
                .brandName(req.getBrandName())
                .regUser(req.getRegUser())
                .build();

        Brand savedBrand = brandRepository.save(brand);
        return brandObjectMapper.toBrandInfo(savedBrand);
    }
}
