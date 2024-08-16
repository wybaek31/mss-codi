package com.mss.codi.admin.product.service;

import com.mss.codi.admin.product.controller.dto.DeleteProductReq;
import com.mss.codi.admin.product.controller.dto.RegisterProductReq;
import com.mss.codi.admin.product.controller.dto.UpdateProductReq;
import com.mss.codi.core.domain.brand.Brand;
import com.mss.codi.core.domain.product.Product;
import com.mss.codi.core.domain.product.ProductInfo;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.enums.DataStatusType;
import com.mss.codi.core.mapper.product.ProductObjectMapper;
import com.mss.codi.core.repository.brand.BrandRepository;
import com.mss.codi.core.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductAdminService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ProductObjectMapper productObjectMapper;

    /**
     * 상품 등록
     * @param req
     * @return
     */
    public ProductInfo registerProduct(RegisterProductReq req) {
        // Step 1. 브랜드 체크.
        Brand brand = brandRepository.findById(req.getBrandId())
                .orElseThrow(() -> new IllegalArgumentException("브랜드 정보가 없습니다."));

        // Step 2. 상품 가격 확인.
        if (req.getPrice() < 0) {
            throw new IllegalArgumentException("상품 가격은 0보다 커야 합니다.");
        }

        Product product = Product.builder()
                .statusType(DataStatusType.USE)
                .productName(req.getProductName())
                .brandId(req.getBrandId())
                .categoryType(CategoryType.valueOf(req.getCategoryType()))
                .price(req.getPrice())
                .regUser(req.getRegUser())
                .build();

        // Step 3. 상품 등록.
        Product savedProduct = productRepository.save(product);
        return productObjectMapper.toProductInfo(savedProduct);
    }

    /**
     * 상품 수정
     * @param productId
     * @param req
     * @return
     */
    public ProductInfo updateProduct(Long productId, UpdateProductReq req) {
        // Step 1. 상품 체크.
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보가 없습니다."));

        // Step 2. 상품 가격 확인.
        if (req.getPrice() < 0) {
            throw new IllegalArgumentException("상품 가격은 0보다 커야 합니다.");
        }

        // Step 3. 상품 수정.
        product.updateProduct(req.getProductName(), CategoryType.valueOf(req.getCategoryType()), req.getPrice(), req.getRegUser());
        Product savedProduct = productRepository.save(product);
        return productObjectMapper.toProductInfo(savedProduct);
    }

    /**
     * 상품 삭제
     * @param productId
     * @param req
     * @return
     */
    public String deleteProduct(Long productId, DeleteProductReq req) {
        // Step 1. 상품 체크.
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보가 없습니다."));

        // Step 2. 상품 삭제.
        product.deleteProduct(req.getRegUser());
        productRepository.delete(product);
        return "SUCCESS";
    }

}
