package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId){
        return new UserDto();
    }

    @DeleteMapping("/{userId}")
    public boolean delete(@PathVariable long userId) {
        return true;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return new UserDto();
    }

    @PutMapping("/{userId}")
    public UserDto block(@PathVariable long userId){
        return new UserDto();
    }

}
