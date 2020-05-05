package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDto extends CrudRepository<Cart, Integer> {
}
