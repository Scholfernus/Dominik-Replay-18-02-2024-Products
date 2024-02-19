package com.example.products.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
}
