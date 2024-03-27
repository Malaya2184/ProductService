package com.spider.productservice.dtos.exceptionDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String exceptionName;
    private String exceptionDetails;
}
