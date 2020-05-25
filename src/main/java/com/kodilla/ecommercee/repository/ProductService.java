package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapToDtos(products);
    }

    public ProductDto get(Long id) {
        Product product = productRepository.getOne(id);
        return productMapper.mapToDto(product);
    }


    public ProductDto create(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
    }

    public ProductDto update(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(productDto.getId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductName(productDto.getProductName());
            product.setProductPrice(productDto.getProductPrice());
            productRepository.save(product);
            return productMapper.mapToDto(product);
        } else {
            throw new RuntimeException("Cannot find product with id: " + productDto.getId());
        }
    }

    public boolean delete(Long productId) {
        Product product = productRepository.getOne(productId);
        productRepository.delete(product);
        return !productRepository.existsById(productId);
    }
}