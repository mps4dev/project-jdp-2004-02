package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId){
        return new UserDto();
    }

    @GetMapping
    public List<UserDto> getAll(){
        return new ArrayList<>();
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable long userId){
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto){
    }

    @PutMapping("/{userId}")
    public void block(@PathVariable long userId){

    }

    @GetMapping("/{userId}")
    public String token(@PathVariable long userId){
        return "";
    }

}
