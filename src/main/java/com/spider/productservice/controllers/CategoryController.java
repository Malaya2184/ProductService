package com.spider.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryController <T>{
    @GetMapping("/{id}")
    ResponseEntity<T> getCategoryById(@PathVariable("id") Long id);
    @GetMapping
    ResponseEntity<List<T>> getAllCategories();
    @PostMapping
    ResponseEntity<T> createNewCategory(@RequestBody T category);
    @PostMapping("/addall")
    ResponseEntity<List<T>> createNewCategories(@RequestBody List<T> categoryList);
    @PatchMapping("/{id}")
    ResponseEntity<T> updateCategory(@PathVariable("id") Long id,@RequestBody T category);
    @PutMapping("/{id}")
    ResponseEntity<T> replacecategory(@PathVariable("id") Long id,@RequestBody T category);
    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable("id") Long id);
}
