package com.kodilla.ecommercee.domain.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "city")
    private String city;

    @Column(name = "code")
    private String code;

    @Column(name = "street")
    private String street;

    @Column(name = "active")
    private boolean active;

    private static Token TOKEN = new Token();

    @Builder
    public User(String firstName, String lastName, String mail, String city, String code, String street, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.city = city;
        this.code = code;
        this.street = street;
        this.active = active;
    }


}
