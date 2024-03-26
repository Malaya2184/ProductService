package com.spider.productservice.controllers;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.models.Product;
import com.spider.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class FakeStoreProductController {
    private final ProductService productService;

    public FakeStoreProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductByid(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
