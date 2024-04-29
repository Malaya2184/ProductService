package com.spider.productservice.commons;

import com.spider.productservice.dtos.userservice_dtos.UserDto;
import com.spider.productservice.exceptions.userServiceExceptions.InvalidTokenException;
import com.spider.productservice.exceptions.userServiceExceptions.UserNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) throws InvalidTokenException, UserNotFoundException {
        try {
            UserDto responseUsrDto = restTemplate.postForObject(
                    "http://localhost:3030/users/validatetoken/" + token,
                    null,
                    UserDto.class
            );
            return  responseUsrDto;
        }catch (Exception e){
            throw new InvalidTokenException(e.getMessage());
        }
    }

}
