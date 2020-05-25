package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        return productDto;
    }

    public List<ProductDto> mapToDtos(List<Product> products) {
        return products.stream()
                .map(product -> mapToDto(product))
                .collect(Collectors.toList());
    }

    public Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        return product;
    }
}
