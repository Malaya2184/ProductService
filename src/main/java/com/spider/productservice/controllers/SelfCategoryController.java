package com.spider.productservice.controllers;

import com.spider.productservice.models.SelfCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SelfCategoryController implements CategoryController<SelfCategory>{
    @Override
    public ResponseEntity<SelfCategory> getCategoryById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SelfCategory>> getAllCategories() {
        return null;
    }

    @Override
    public ResponseEntity<SelfCategory> createNewCategory(SelfCategory category) {
        return null;
    }

    @Override
    public ResponseEntity<List<SelfCategory>> createNewCategories(List<SelfCategory> categoryList) {
        return null;
    }

    @Override
    public ResponseEntity<SelfCategory> updateCategory(SelfCategory category) {
        return null;
    }

    @Override
    public ResponseEntity<SelfCategory> replacecategory(SelfCategory category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
