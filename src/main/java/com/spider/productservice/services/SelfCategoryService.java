package com.spider.productservice.services;

import com.spider.productservice.exceptions.CategoryNotFoundException;
import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService<SelfCategory>{
    private CategoryRepository categoryrepository;

    public SelfCategoryService(CategoryRepository categoryrepository) {
        this.categoryrepository = categoryrepository;
    }

    @Override
    public ResponseEntity<SelfCategory> getCategoryById(Long id) {
        Optional<SelfCategory> category = categoryrepository.findById(id);
        if (category.isEmpty()) {
            throw new CategoryNotFoundException(id,"Category not found for the id :" + id);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SelfCategory>> getAllCategories() {
        List<SelfCategory> categories = categoryrepository.findAll();
        if (categories.size() == 0){
            throw new CategoryNotFoundException(null,"There is no category presesnt in db");
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SelfCategory> createNewCategory(SelfCategory category) {
        SelfCategory savedCategory = categoryrepository.save(category);
        return new ResponseEntity<>(savedCategory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SelfCategory>> createNewCategories(List<SelfCategory> categoryList) {
        List<SelfCategory> savedCategories = new ArrayList<>();
        for(SelfCategory c : categoryList){
            savedCategories.add(categoryrepository.save(c));
        }
        return new ResponseEntity<>(savedCategories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SelfCategory> updateCategory(Long id,SelfCategory category) {
        Optional<SelfCategory> response = categoryrepository.findById(id);
        if (response == null) {
            throw new CategoryNotFoundException(id,"CategoryNotFound for the categoryId: "+id);
        }
        SelfCategory categoryById = response.get();
        categoryById.setTitle(category.getTitle());
        categoryById.setUpdatedAt(new Date());
        SelfCategory updatedcategory = categoryrepository.save(categoryById);
        return new ResponseEntity<>(updatedcategory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SelfCategory> replacecategory(Long id,SelfCategory category) {
        Optional<SelfCategory> response = categoryrepository.findById(id);
        if (response == null) {
            throw new CategoryNotFoundException(id,"CategoryNotFound for the categoryId: "+id);
        }
        SelfCategory categoryById = response.get();
        categoryById.setTitle(category.getTitle());
        categoryById.setUpdatedAt(new Date());
        SelfCategory updatedcategory = categoryrepository.save(categoryById);
        return new ResponseEntity<>(updatedcategory,HttpStatus.OK);
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
