package com.github.yoruhinda.eletronicCommercer.services;

import com.github.yoruhinda.eletronicCommercer.dto.product.ProductDto;
import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import com.github.yoruhinda.eletronicCommercer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            ProductDto productDto = new ProductDto(product.getId(), product.getProduct_name(), product.getProduct_description(), product.getProduct_quantity(), product.getProduct_price());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public ProductDto findById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Não foi possivel localizar o produto!");
        }
        Product product = productRepository.findById(id).get();
        return new ProductDto(product.getId(), product.getProduct_name(), product.getProduct_description(), product.getProduct_quantity(), product.getProduct_price());
    }

    public ProductDto saveProduct(ProductDto productDto) {
        productRepository.save(productDto.toModel());
        return productDto;
    }

    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Não foi possivel localizar o produto!");
        }
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Não foi possivel localizar o produto!");
        }
        Product product = productDto.toModel();
        product.setId(id);
        productRepository.save(product);
        return productDto;
    }
}
