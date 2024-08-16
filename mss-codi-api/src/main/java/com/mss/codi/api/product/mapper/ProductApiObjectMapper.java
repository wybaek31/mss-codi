package com.mss.codi.api.product.mapper;

import com.mss.codi.api.product.controller.dto.BrandCategoryMinPricesRes;
import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.repository.product.dto.BrandCategoryPriceDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductApiObjectMapper {

    @Mappings({
            @Mapping(target = "categoryName", source = "categoryType", qualifiedByName = "getCategoryTypeName"),
            @Mapping(target = "price", source = "price")
    })
    @Named(value = "toBrandCategoryMinPricesInfo")
    BrandCategoryMinPricesRes.BrandCategoryMinPricesInfo toBrandCategoryMinPricesInfo(BrandCategoryPriceDto brandCategoryPriceDto);

    @IterableMapping(qualifiedByName = "toBrandCategoryMinPricesInfo")
    List<BrandCategoryMinPricesRes.BrandCategoryMinPricesInfo> toBrandCategoryMinPricesInfoList(List<BrandCategoryPriceDto> brandCategoryPriceDto);

    @Named("getCategoryTypeName")
    default String getCategoryTypeName(CategoryType categoryType) {
        return categoryType.getCategoryName();
    }
}
