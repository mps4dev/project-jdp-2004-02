package com.kodilla.ecommercee.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private double productQuantity;
    private BigDecimal sum;

    @OneToMany(targetEntity = Product.class,
               mappedBy = "cart",
               fetch = FetchType.LAZY)
    private List<Product> cartContent = new ArrayList<>();

    public Cart(double productQuantity) {
        this.productQuantity = productQuantity;
        this.sum = (BigDecimal)getProductId().getProductPrice()*productQuantity;
    }
}
