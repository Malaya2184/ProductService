package com.spider.productservice.controllers;

import com.spider.productservice.dtos.FakeStoreProductDto;
import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.models.Product;
import com.spider.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class FakeStoreProductController {
    private final ProductService productService;

    public FakeStoreProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getProductByid(id);
//        throw new RuntimeException("Throwing run time exception");
//        try {
//            throw new RuntimeException("Exception thrown from try catch block");
//        }catch (RuntimeException e){
//            System.out.println("Exception caught and handelled in try catch block");
//        }
/*         There might be seeveral type of exceptions we need to handle so we can't handle all
           the exceptions insid econtrollers otherwise th redability will be affected so we can use controller advice to handle all the excepptions throwen by controller
*/
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        throw new ProductNotFoundException("Product  Not found for the product id : "+id, id);
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product productResponse = productService.createProduct(product);
        if(productResponse != null){
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

    @GetMapping("/throughexception")
    public void throughArithmeticException(){
//        the message will sent from here automatically catch by the Controller advice
        int x = 10/0;
    }
}
