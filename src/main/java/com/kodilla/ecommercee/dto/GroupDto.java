package com.kodilla.ecommercee.dto;

import java.util.List;

public class GroupDto {
    private String name;
    private List<ProductDto> productDto;

    public GroupDto(String name, List<ProductDto> productDto) {
        this.name = name;
        this.productDto = productDto;
    }

    public GroupDto(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProductDto() {
        return productDto;
    }

    public void setProductDto(List<ProductDto> productDto) {
        this.productDto = productDto;
    }
}
