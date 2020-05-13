package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

}
