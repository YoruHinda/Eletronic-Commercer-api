package com.github.yoruhinda.eletronicCommercer.controller;

import com.github.yoruhinda.eletronicCommercer.domain.dto.product.ProductDto;
import com.github.yoruhinda.eletronicCommercer.services.ImageService;
import com.github.yoruhinda.eletronicCommercer.services.ProductService;
import com.github.yoruhinda.eletronicCommercer.util.ProductCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductService productService;
    @Mock
    private ImageService imageService;

    @BeforeEach
    void setUp(){
        BDDMockito.when(productService.getAllProducts()).thenReturn(List.of(ProductCreator.createProduct()));
        BDDMockito.when(productService.findById(ArgumentMatchers.anyLong())).thenReturn(ProductCreator.createValidProduct());
    }

    @Test
    @DisplayName("List Return List Of Products When Successful")
    void list_ReturnListOfProducts_WhenSuccessful(){
        String product_name = ProductCreator.createProduct().getProduct_name();
        List<ProductDto> productDtoList = productController.findAllProduct().getBody();
        Assertions.assertThat(productDtoList).isNotNull().isNotEmpty().hasSize(1);
        Assertions.assertThat(productDtoList.get(0).getProduct_name()).isEqualTo(product_name);
    }

    @Test
    @DisplayName("Return Product By ID When Successful")
    void returnProductById_WhenSuccessful(){
        Long id = ProductCreator.createProduct().getId();
        ProductDto product = productController.findProductById(id).getBody();
        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(product.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("Return Product Image When Successful")
    void returnProductImageWhenSuccessful(){

    }

    @Test
    @DisplayName("Post Product When Successful")
    void postProductWhenSuccessful(){

    }

    @Test
    @DisplayName("Delete Product When Successful")
    void deleteProductWhenSuccessful(){

    }

    @Test
    @DisplayName("Update Product When Successful")
    void updateProductWhenSuccessful(){

    }
}