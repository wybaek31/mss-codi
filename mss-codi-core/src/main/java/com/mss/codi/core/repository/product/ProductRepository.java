package com.mss.codi.core.repository.product;

import com.mss.codi.core.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryRepository {

}
