package com.mss.codi.core.mapper.brand;

import com.mss.codi.core.domain.brand.Brand;
import com.mss.codi.core.domain.brand.BrandInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface BrandObjectMapper {

    BrandInfo toBrandInfo(Brand brand);
}
