package com.github.yoruhinda.eletronicCommercer.repository;

import com.github.yoruhinda.eletronicCommercer.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
