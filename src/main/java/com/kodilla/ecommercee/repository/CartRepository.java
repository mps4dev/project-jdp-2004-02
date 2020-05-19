package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends GenericEntityRepository<Cart> {
}
