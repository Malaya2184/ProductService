package com.spider.productservice.advices;


import com.spider.productservice.dtos.exceptionDto.userServiceExceptionDtos.InvalidTokenDto;
import com.spider.productservice.dtos.exceptionDto.userServiceExceptionDtos.UserNotFoundDto;
import com.spider.productservice.exceptions.userServiceExceptions.InvalidTokenException;
import com.spider.productservice.exceptions.userServiceExceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<InvalidTokenDto> handleInvalidPasswordException(InvalidTokenException e){
        InvalidTokenDto invalidTokenDto = new InvalidTokenDto(e.getMessage());
        return new ResponseEntity<>(invalidTokenDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public  ResponseEntity<UserNotFoundDto> handleUserNotFoundException(UserNotFoundException e){
        UserNotFoundDto userNotFoundDto = new UserNotFoundDto(e.getMessage());
        return new ResponseEntity<>(userNotFoundDto,HttpStatus.NOT_FOUND);
    }
}
