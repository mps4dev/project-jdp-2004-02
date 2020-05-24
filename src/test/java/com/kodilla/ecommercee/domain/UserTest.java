package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserRepository userRepository;

    private Cart cart = new Cart();
    private User user = new User();
    private List<Order> orders = new ArrayList<>();

    public void starter(){
        Order order = new Order();
        orders.add(order);

        user.setStatus(true);
        user.setName("test");
        user.setCart(cart);
        user.setOrders(orders);

        userRepository.save(user);
    }

    @After
    public void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    public void createRead(){
        //Given
        starter();

        //When
        User savedUser = userRepository.findById(user.getId()).get();

        //Then
        List<Order> userOrders = savedUser.getOrders();
        Cart userCart = savedUser.getCart();

        assertEquals("test", savedUser.getName());
        assertEquals(true,savedUser.isStatus());
        assertEquals(1, userOrders.size());
        assertNotNull(userCart);
    }

    @Test
    public void update(){
        //Given
        starter();

        //When
        User savedUser = userRepository.findById(user.getId()).get();
        savedUser.setName("update");
        savedUser.setStatus(false);

        User updateUser = userRepository.save(savedUser);

        //Then
        List<Order> userOrders = updateUser.getOrders();
        Cart userCart = updateUser.getCart();

        assertEquals("update", updateUser.getName());
        assertEquals(false, updateUser.isStatus());
        assertEquals(1, userOrders.size());
        assertNotNull(userCart);
    }

    @Test
    public void delete(){
        //Given
        starter();

        //When
        userRepository.delete(user);

        //Then
        boolean isDeleted = userRepository.existsById(user.getId());
        assertFalse(isDeleted);
    }

}