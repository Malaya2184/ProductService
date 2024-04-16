package com.spider.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface CategoryController <T>{
    @GetMapping("/{id}")
    ResponseEntity<T> getCategoryById(@PathVariable("id") Long id);
    @GetMapping
    ResponseEntity<List<T>> getAllCategories();
    @PostMapping
    ResponseEntity<T> createNewCategory(@RequestBody T category);
    @PostMapping
    ResponseEntity<List<T>> createNewCategories(@RequestBody List<T> categoryList);
    @PatchMapping
    ResponseEntity<T> updateCategory(@RequestBody T category);
    @PutMapping
    ResponseEntity<T> replacecategory(@RequestBody T category);
    @DeleteMapping("/{id}")
    void dleteCategory(@PathVariable("id") Long id);
}
