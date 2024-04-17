package com.spider.productservice.services;

import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class SelfCategoryService implements CategoryService<SelfCategory>{
    private CategoryRepository categoryrepository;

    public SelfCategoryService(CategoryRepository categoryrepository) {
        this.categoryrepository = categoryrepository;
    }

    @Override
    public ResponseEntity<SelfCategory> getCategoryById(Long id) {
        Optional<SelfCategory> category = categoryrepository.findById(id);
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
