package com.spider.productservice.services;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SelfProductServiceTestMock {
    @Autowired
//    here i can use product service directly because it is indicating selfProduct service as it is declared as primary
    private SelfProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("service return the product not found exception")
    public void serviceReturnTheProductNotFoundException() {
        Optional<SelfProduct> p = Optional.empty();
        when(productRepository.findById(1L)).thenReturn(p);
        when(productRepository.findById(2L)).thenReturn(null);

//        if it will retun exception then service is workking perfectly
        assertThrows(ProductNotFoundException.class,
                () -> productService.getProductByid(1L));
        assertThrows(NullPointerException.class,
                () -> productService.getProductByid(2L));

    }
}