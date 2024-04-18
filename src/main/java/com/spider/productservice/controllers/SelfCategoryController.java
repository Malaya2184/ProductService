package com.spider.productservice.controllers;

import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/self/category")
public class SelfCategoryController implements CategoryController<SelfCategory>{
    private final CategoryService categoryService;

    public SelfCategoryController(@Qualifier("selfCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<SelfCategory> getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @Override
    public ResponseEntity<List<SelfCategory>> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @Override
    public ResponseEntity<SelfCategory> createNewCategory(SelfCategory category) {
        return categoryService.createNewCategory(category);
    }

    @Override
    public ResponseEntity<List<SelfCategory>> createNewCategories(List<SelfCategory> categoryList) {

        return categoryService.createNewCategories(categoryList);
    }

    @Override
    public ResponseEntity<SelfCategory> updateCategory(Long id,SelfCategory category) {
        return categoryService.updateCategory(id,category);
    }

    @Override
    public ResponseEntity<SelfCategory> replacecategory(Long id, SelfCategory category) {
        return categoryService.replacecategory(id,category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }
}
