package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User extends GenericEntity {

    private String name;
    private boolean status;

    @OneToMany(
            targetEntity = Order.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();

    @OneToOne(
            targetEntity = Cart.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Cart cart = new Cart();
}
