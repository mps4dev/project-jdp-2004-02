package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @GetMapping
    public UserDto getUser(@RequestParam(value = "id") long id){
        return new UserDto();
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return new ArrayList<>();
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(value = "id")long id){
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto){
        userDto.getToken().generateToken();
    }

    @PutMapping
    public void block(@RequestParam(value = "param") long param){

    }

}