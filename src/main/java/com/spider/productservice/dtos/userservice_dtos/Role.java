package com.spider.productservice.dtos.userservice_dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private  Long id;
    private boolean deleted;
    private String value;
}
