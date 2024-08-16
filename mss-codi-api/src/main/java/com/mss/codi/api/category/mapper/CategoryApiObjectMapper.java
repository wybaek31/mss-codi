package com.mss.codi.api.category.mapper;

import com.mss.codi.api.category.controller.dto.ProductMinMaxPriceRes;
import com.mss.codi.core.repository.product.dto.CategoryPriceDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CategoryApiObjectMapper {
    ProductMinMaxPriceRes.ProductMinMaxPriceInfo toProductMinMaxPriceInfo(CategoryPriceDto categoryPriceDto);
}
