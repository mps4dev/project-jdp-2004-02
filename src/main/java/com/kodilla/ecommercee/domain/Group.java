package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "GROUPS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group extends GenericEntity {
    private long groupId;
    private String type;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "groupList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productList = new ArrayList<>();
}
