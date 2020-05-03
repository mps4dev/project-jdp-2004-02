package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
