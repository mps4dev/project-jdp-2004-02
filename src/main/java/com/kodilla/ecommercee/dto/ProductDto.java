package com.kodilla.ecommercee.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String productName;
    private double productPrice;

}
