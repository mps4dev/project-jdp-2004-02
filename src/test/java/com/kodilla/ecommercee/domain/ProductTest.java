package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    private Product product = new Product();
    private Order order = new Order();
    private Cart cart = new Cart();
    private Group group = new Group();

    @Before
    public void beforeTest() {
        product.setProductName("product");
        product.setProductPrice(100.0);
        product.setOrder(order);
        product.setCart(cart);
        product.setGroup(group);

        productRepository.save(product);
    }

    @After
    public void afterTest() {
        productRepository.delete(product);
    }

    @Test
    public void shouldCreateAndReadProduct() {
        //When
        Product savedProduct = productRepository.findById(product.getId()).get();

        //Then
        Group savedGroup = savedProduct.getGroup();
        Cart savedCart = savedProduct.getCart();
        Order savedOrder = savedProduct.getOrder();

        assertNotNull(savedGroup);
        assertNotNull(savedCart);
        assertNotNull(savedOrder);
        assertEquals("product", savedProduct.getProductName());
        assertEquals(100.0, savedProduct.getProductPrice(), 0);
    }

    @Test
    public void shouldUpdateProduct() {
        //When
        Product savedProduct = productRepository.findById(product.getId()).get();

        product.setProductName("update");
        product.setProductPrice(200.0);
        savedProduct.setGroup(group);
        savedProduct.setCart(cart);
        savedProduct.setOrder(order);

        Product updatedProduct = productRepository.save(savedProduct);

        //Then
        Cart updatedCart = updatedProduct.getCart();
        Group updatedGroup = updatedProduct.getGroup();
        Order updatedOrder = updatedProduct.getOrder();

        assertNotNull(updatedCart);
        assertNotNull(updatedGroup);
        assertNotNull(updatedOrder);
        assertEquals("update", updatedProduct.getProductName());
        assertEquals(200.0, updatedProduct.getProductPrice(), 0);
    }

    @Test
    public void shouldDeleteProduct() {
        //When
        productRepository.delete(product);

        //Then
        boolean isDeleted = productRepository.existsById(product.getId());

        assertFalse(isDeleted);
    }
}


