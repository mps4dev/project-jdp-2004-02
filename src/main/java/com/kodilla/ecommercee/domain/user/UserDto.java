package com.kodilla.ecommercee.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String city;
    private String code;
    private String street;
    private boolean active = true;
    private static Token TOKEN = new Token();

    @Builder
    public UserDto(String firstName, String lastName, String mail, String city, String code, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.city = city;
        this.code = code;
        this.street = street;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
