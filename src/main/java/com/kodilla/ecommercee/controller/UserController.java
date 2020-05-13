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
    public void delete(@PathVariable long userId){
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto){ ;
    }

    @PutMapping("/{userId}")
    public UserDto block(@PathVariable long userId){
        return new UserDto();
    }

}
