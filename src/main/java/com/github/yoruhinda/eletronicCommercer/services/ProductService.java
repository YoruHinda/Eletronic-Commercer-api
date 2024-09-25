package com.github.yoruhinda.eletronicCommercer.services;

import com.github.yoruhinda.eletronicCommercer.models.Product;
import com.github.yoruhinda.eletronicCommercer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        return null;
    }
}
