package com.spider.productservice.controllers;

import com.spider.productservice.models.SelfCategory;
import com.spider.productservice.services.SelfCategoryService;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SelfCategoryControllerTest {

    @Mock
    private SelfCategoryService categoryService;

    @InjectMocks
    private SelfCategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryController = new SelfCategoryController(categoryService);
    }

    @Test
    public void testGetCategoryById() {
        Long id = 1L;
        SelfCategory category = new SelfCategory();
        ResponseEntity<SelfCategory> expectedResponse = new ResponseEntity<>(category, HttpStatus.OK);
        when(categoryService.getCategoryById(id)).thenReturn(expectedResponse);

        ResponseEntity<SelfCategory> responseEntity = categoryController.getCategoryById(id);
        SelfCategory responseCategory = responseEntity.getBody();

        System.out.println("Expected Response: " + expectedResponse);
        System.out.println("Actual Response: " + responseEntity);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseCategory);
        assertEquals(category, responseCategory);
    }

    @Test
    public void testGetAllCategories() {
        List<SelfCategory> categoryList = new ArrayList<>();
        when(categoryService.getAllCategories()).thenReturn(new ResponseEntity<>(categoryList, HttpStatus.OK));

        ResponseEntity<List<SelfCategory>> response = categoryController.getAllCategories();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryList, response.getBody());
    }

    @Test
    public void testCreateNewCategory() {
        SelfCategory category = new SelfCategory();
        when(categoryService.createNewCategory(category)).thenReturn(new ResponseEntity<>(category, HttpStatus.OK));

        ResponseEntity<SelfCategory> response = categoryController.createNewCategory(category);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    public void testCreateNewCategories() {
        List<SelfCategory> categoryList = new ArrayList<>();
        when(categoryService.createNewCategories(categoryList)).thenReturn(new ResponseEntity<>(categoryList, HttpStatus.OK));

        ResponseEntity<List<SelfCategory>> response = categoryController.createNewCategories(categoryList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryList, response.getBody());
    }

    @Test
    public void testUpdateCategory() {
        Long id = 1L;
        SelfCategory category = new SelfCategory();
        when(categoryService.updateCategory(id, category)).thenReturn(new ResponseEntity<>(category, HttpStatus.OK));

        ResponseEntity<SelfCategory> response = categoryController.updateCategory(id, category);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    public void testReplacecategory() {
        Long id = 1L;
        SelfCategory category = new SelfCategory();
        when(categoryService.replacecategory(id, category)).thenReturn(new ResponseEntity<>(category, HttpStatus.OK));

        ResponseEntity<SelfCategory> response = categoryController.replacecategory(id, category);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    public void testDeleteCategory() {
        Long id = 1L;
        categoryController.deleteCategory(id);
        verify(categoryService, times(1)).deleteCategory(id);
    }
}
