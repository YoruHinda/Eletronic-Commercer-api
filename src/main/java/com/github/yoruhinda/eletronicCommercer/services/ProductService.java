package com.github.yoruhinda.eletronicCommercer.services;

import com.github.yoruhinda.eletronicCommercer.dto.product.ProductDtoRequest;
import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import com.github.yoruhinda.eletronicCommercer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        return null;
    }

    public void deleteProduct(Long id){
        if (productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
            productRepository.delete(product);
        }
    }

    public void updateProduct(Long id, Product products){
        if (productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
        }
    }
}
