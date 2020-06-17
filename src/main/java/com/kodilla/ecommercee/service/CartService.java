package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;

    public CartDto create(final CartDto cartDto) {
        Cart cart = cartMapper.mapToEntity(cartDto);
        Cart saveCart = cartRepository.save(cart);

        return cartMapper.mapToDto(saveCart);
    }

    public List<ProductDto> getAllProducts(final long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cannot find cart with id: " + cartId));

        return cart.getProducts().stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public boolean addProduct(final long productId, final long cartId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Cannot find product with id: " + productId));
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cannot find cart with id: " + cartId));

        List<Product> products = cart.getProducts();
        products.add(product);
        product.setCart(cart);
        cart.setProducts(products);
        cartRepository.save(cart);

        return true;
    }

    public ProductDto getProduct(final long productId, final long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cannot find cart with id: " + cartId));

        return cart.getProducts().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .map(productMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException(""));
    }

    public boolean deleteProduct(final long productId, final long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cannot find cart with id: " + cartId));

        boolean productWasDeleted = cart.getProducts().removeIf(p -> p.getId().equals(productId));
        cartRepository.save(cart);

        return productWasDeleted;
    }

    public OrderDto makeOrder(final CartDto cartDto) {
        cartRepository.deleteById(cartDto.getId());

        return new OrderDto();                          // tymczasowo zwracam pusty DTO, czekam na OrderController
    }
}
