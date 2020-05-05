package com.kodilla.ecommercee.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
    public Token token;

    public Token getToken() {
        return token;
    }
}
