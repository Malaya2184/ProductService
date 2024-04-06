package com.spider.productservice.controllers;

import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductController<T> {

    @GetMapping("/{id}")
    ResponseEntity<T> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException;

    @GetMapping
    List<T> getAllProducts();

    @PostMapping
    ResponseEntity<T> createProduct(@RequestBody T product);

    @PatchMapping("/{id}")
    T updateProduct(@PathVariable("id") Long id, @RequestBody T product);

    @PutMapping("/{id}")
    T replaceProduct(@PathVariable("id") Long id, @RequestBody T product) throws FakeStoreSpecificException;

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}
