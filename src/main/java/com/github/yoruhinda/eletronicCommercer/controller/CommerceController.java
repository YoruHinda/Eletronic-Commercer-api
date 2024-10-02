package com.github.yoruhinda.eletronicCommercer.controller;

import com.github.yoruhinda.eletronicCommercer.dto.product.ProductDto;
import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import com.github.yoruhinda.eletronicCommercer.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommerceController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> postProduct(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }
}
