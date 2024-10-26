package com.github.yoruhinda.eletronicCommercer.controller;

import com.github.yoruhinda.eletronicCommercer.dto.product.ProductDto;
import com.github.yoruhinda.eletronicCommercer.services.ImageService;
import com.github.yoruhinda.eletronicCommercer.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ImageService imageService;
    private String imageDirectory = "src/main/resources/static/images/products";

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> findAllProduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/product_image/{id}")
    public ResponseEntity<List<byte[]>> findImageByProductId(@PathVariable("id") Long id){
        try {
            ProductDto byId = productService.findById(id);
            String productImageName = byId.getProduct_image_name();
            List<byte[]> imageBytesList = new ArrayList<>();
            imageBytesList.add(imageService.getImage(imageDirectory, productImageName));
            return new ResponseEntity<>(imageBytesList, HttpStatus.OK);
        }catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ProductDto> postProduct(@RequestPart("product") @Valid ProductDto productDto, @RequestPart("productImage") MultipartFile productImage) {
        try {
            String imageName = imageService.saveImageToStorage(imageDirectory, productImage);
            return new ResponseEntity<>(productService.saveProduct(productDto, imageName), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
