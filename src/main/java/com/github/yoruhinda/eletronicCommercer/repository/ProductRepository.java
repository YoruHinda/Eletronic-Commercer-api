package com.github.yoruhinda.eletronicCommercer.repository;

import com.github.yoruhinda.eletronicCommercer.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
