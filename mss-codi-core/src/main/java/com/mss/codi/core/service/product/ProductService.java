package com.mss.codi.core.service.product;

import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.ProductRepository;
import com.mss.codi.core.repository.product.dto.BrandCategoryMinPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryMinPriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public CategoryMinPriceDto getMinProductByCategoryType(CategoryType categoryType) {
        return productRepository.findCategoryTypeOrderByPriceAsc(categoryType);
    }

    public List<BrandCategoryMinPriceDto> getBrandCategoryMinPrices(CategoryType[] categoryTypes) {
        return productRepository.findBrandIdAndCategoryTypeOrderByPriceAsc(categoryTypes);
    }
}
