package com.spider.productservice.controllers;

import com.spider.productservice.dtos.exceptionDto.FakeStoreSpecificExceptionDto;
import com.spider.productservice.exceptions.ProductNotFoundException;
import com.spider.productservice.exceptions.specificexcrption.FakeStoreSpecificException;
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
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    // Specific Exception for this controller so made it private
    @ExceptionHandler(FakeStoreSpecificException.class)
    private ResponseEntity<FakeStoreSpecificExceptionDto> handelSpecificException(FakeStoreSpecificException e){
        FakeStoreSpecificExceptionDto fakeStoreSpecificExceptionDto = new FakeStoreSpecificExceptionDto();
        fakeStoreSpecificExceptionDto.setMessage(e.getMessage());
        fakeStoreSpecificExceptionDto.setName(e.getName());
        return new ResponseEntity<>(fakeStoreSpecificExceptionDto, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws FakeStoreSpecificException{
         Product response = productService.replaceProduct(id, product);
//         make rsponse null to check wheather specific exception is working or not
//         response = null;
         if(response != null){
             return response;
         }
        throw new FakeStoreSpecificException("Product not found , So can't replace it", "Product replacement failed exception");
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }

    @GetMapping("/througharithemeticexception")
    public void throughArithmeticException(){
//        the message will sent from here automatically catch by the Controller advice
        int x = 10/0;
    }
}
