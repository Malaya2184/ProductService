package com.spider.productservice.controllers;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import com.spider.productservice.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductController {

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException;

    @GetMapping
    List<Product> getAllProducts();

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product);

    @PatchMapping("/{id}")
    Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product);

    @PutMapping("/{id}")
    Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws FakeStoreSpecificException;

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}
