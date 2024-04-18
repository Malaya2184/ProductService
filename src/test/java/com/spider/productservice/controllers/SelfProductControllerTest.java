package com.spider.productservice.controllers;

import com.spider.productservice.dtos.ProductCategoryDto;
import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import com.spider.productservice.models.SelfProduct;
import com.spider.productservice.services.SelfProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SelfProductControllerTest {

    @Mock
    private SelfProductService productService;

    @InjectMocks
    private SelfProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() throws ProductNotFoundException {
        SelfProduct product = new SelfProduct();
        product.setId(1L);
        when(productService.getProductByid(1L)).thenReturn(product);

        ResponseEntity<SelfProduct> response = productController.getProductById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testGetAllProducts() {
        List<SelfProduct> productList = new ArrayList<>();
        productList.add(new SelfProduct());
        when(productService.getAllProducts()).thenReturn(productList);

        List<SelfProduct> response = productController.getAllProducts();
        assertEquals(productList, response);
    }

    @Test
    public void testCreateProduct() {
        SelfProduct product = new SelfProduct();
        when(productService.createProduct(product)).thenReturn(product);

        ResponseEntity<SelfProduct> response = productController.createProduct(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        Long id = 1L;
        SelfProduct product = new SelfProduct();
        when(productService.updateProduct(id, product)).thenReturn(product);

        SelfProduct response = productController.updateProduct(id, product);
        assertEquals(product, response);
    }

    @Test
    public void testReplaceProduct() throws FakeStoreSpecificException {
        Long id = 1L;
        SelfProduct product = new SelfProduct();
        when(productService.replaceProduct(id, product)).thenReturn(product);

        SelfProduct response = productController.replaceProduct(id, product);
        assertEquals(product, response);
    }

    @Test
    public void testDeleteProduct() {
        Long id = 1L;
        productController.deleteProduct(id);
        verify(productService, times(1)).deleteProduct(id);
    }

    @Test
    public void testGetProductByTitleLike() {
        String phrase = "phrase";
        List<SelfProduct> productList = new ArrayList<>();
        when(productService.getProductByTitleLike(phrase)).thenReturn(productList);

        List<SelfProduct> response = productController.getProductByTitleLike(phrase);
        assertEquals(productList, response);
    }

    @Test
    public void testUpdateProductPost() {
        Long id = 1L;
        SelfProduct product = new SelfProduct();
        when(productService.updateProductPost(id, product)).thenReturn(new ResponseEntity<>(product, HttpStatus.OK));

        ResponseEntity<SelfProduct> response = productController.updateProductPost(id, product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testFindProductCategory() {
        List<ProductCategoryDto> categoryList = new ArrayList<>();
        when(productService.findProductCategory()).thenReturn(new ResponseEntity<>(categoryList, HttpStatus.OK));

        ResponseEntity<List<ProductCategoryDto>> response = productController.findProductCategory();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryList, response.getBody());
    }
}
