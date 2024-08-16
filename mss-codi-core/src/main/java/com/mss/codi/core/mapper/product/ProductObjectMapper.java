package com.mss.codi.core.mapper.product;

import com.mss.codi.core.domain.product.Product;
import com.mss.codi.core.domain.product.ProductInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductObjectMapper {

    ProductInfo toProductInfo(Product product);
}
