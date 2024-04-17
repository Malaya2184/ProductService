package com.spider.productservice.advices;

import com.spider.productservice.dtos.exceptionDto.CategoryNotFoundDto;
import com.spider.productservice.dtos.exceptionDto.ExceptionDto;
import com.spider.productservice.dtos.exceptionDto.ProductNotFoundDto;
import com.spider.productservice.exceptions.CategoryNotFoundException;
import com.spider.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class) // this method will act as a catch block
    public ResponseEntity<ExceptionDto> handleAerithemeticException(ArithmeticException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setExceptionName("Arithmetic Exception");
        exceptionDto.setExceptionDetails(e.getMessage());

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setId(e.getId());
        productNotFoundDto.setExceptionDetails(e.getMessage());
        productNotFoundDto.setExceptionName(e.getExceptionName());
        return new ResponseEntity<>(productNotFoundDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<CategoryNotFoundDto> handleCategoryNotFoundException(CategoryNotFoundException e){
        CategoryNotFoundDto categoryNotFoundDto = new CategoryNotFoundDto();
        categoryNotFoundDto.setExceptionName(e.getExceptionName());
        categoryNotFoundDto.setExceptionDetails(e.getMessage());
        categoryNotFoundDto.setId(e.getId());
        return new ResponseEntity<>(categoryNotFoundDto,HttpStatus.NOT_FOUND);
    }
}
