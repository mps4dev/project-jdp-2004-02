package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart mapToEntity(final CartDto dto) {
        Cart cart = new Cart();
        cart.setId(dto.getId());
        return cart;
    }

    public CartDto mapToDto(final Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        return cartDto;
    }
}
