package com.spider.productservice.dtos.exceptionDto.userServiceExceptionDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundDto {
    private String message;
}
