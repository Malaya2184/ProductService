package com.spider.productservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryService<T> {
    ResponseEntity<T> getCategoryById(Long id);
    ResponseEntity<List<T>> getAllCategories();
    ResponseEntity<T> createNewCategory(T category);
    ResponseEntity<List<T>> createNewCategories(List<T> categoryList);
    ResponseEntity<T> updateCategory(T category);
    ResponseEntity<T> replacecategory(T category);
    void deleteCategory(Long id);

}
