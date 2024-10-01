package com.github.yoruhinda.eletronicCommercer.repository;

import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
