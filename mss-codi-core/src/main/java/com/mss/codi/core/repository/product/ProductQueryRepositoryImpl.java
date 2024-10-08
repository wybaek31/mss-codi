package com.mss.codi.core.repository.product;

import com.mss.codi.core.enums.CategoryType;
import com.mss.codi.core.enums.DataStatusType;
import com.mss.codi.core.repository.product.dto.BrandCategoryPriceDto;
import com.mss.codi.core.repository.product.dto.CategoryPriceDto;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mss.codi.core.domain.brand.QBrand.brand;
import static com.mss.codi.core.domain.product.QProduct.product;

@Repository
public class ProductQueryRepositoryImpl implements ProductQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ProductQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public CategoryPriceDto findCategoryTypeOrderByPriceAsc(CategoryType categoryType) {
        // 카테고리별 최저가 상품 조회.
        Tuple result = queryFactory.select(brand.brandName, product.price)
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .where(product.statusType.eq(DataStatusType.USE),
                        product.categoryType.eq(categoryType))
                .orderBy(product.price.asc())
                .fetchFirst();

        if (result != null) {
            return CategoryPriceDto.builder()
                    .categoryName(categoryType.getCategoryName())
                    .brandName(result.get(brand.brandName))
                    .price(result.get(product.price))
                    .build();
        }

        return null;
    }

    @Override
    public CategoryPriceDto findCategoryTypeOrderByPriceDesc(CategoryType categoryType) {
        // 카테고리별 최저가 상품 조회.
        Tuple result = queryFactory.select(brand.brandName, product.price)
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .where(product.statusType.eq(DataStatusType.USE),
                        product.categoryType.eq(categoryType))
                .orderBy(product.price.desc())
                .fetchFirst();

        if (result != null) {
            return CategoryPriceDto.builder()
                    .categoryName(categoryType.getCategoryName())
                    .brandName(result.get(brand.brandName))
                    .price(result.get(product.price))
                    .build();
        }

        return null;
    }

    @Override
    public List<BrandCategoryPriceDto> findBrandIdAndCategoryTypeOrderByPriceAsc(CategoryType[] categories) {

        List<Tuple> results = queryFactory
                .select(product.brandId, brand.brandName, product.categoryType, product.price.min())
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .where(product.statusType.eq(DataStatusType.USE),
                        product.categoryType.in(categories))
                .groupBy(product.brandId, product.categoryType)
                .orderBy(product.brandId.asc())
                .fetch();

        if (results != null) {
            return results.stream()
                    .map(tuple -> BrandCategoryPriceDto.builder()
                            .brandId(tuple.get(product.brandId))
                            .brandName(tuple.get(brand.brandName))
                            .categoryType(tuple.get(product.categoryType))
                            .price(tuple.get(product.price.min()))
                            .build())
                    .toList();
        }

        return null;
    }

}
