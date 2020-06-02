package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends GenericEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

}
