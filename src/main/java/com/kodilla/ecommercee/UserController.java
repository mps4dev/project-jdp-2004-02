package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.user.Token;
import com.kodilla.ecommercee.domain.user.User;
import com.kodilla.ecommercee.domain.user.UserDto;
import com.kodilla.ecommercee.mapper.user.UserMapper;
import com.kodilla.ecommercee.service.user.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DbUserService dbUserService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "getAll")
    public List<UserDto> getAll(){
        return userMapper.mapToUserDtoList(dbUserService.getAllUsers());
    }

    @PostMapping(value = "create",consumes = "application/json")
    public void create(@RequestBody UserDto userDto){
        dbUserService.save(userMapper.mapToUser(userDto));
        Token token = new Token();
        token.generateToken();
    }

    @PutMapping(value = "block")
    public void block(@RequestParam(value = "userId") Long userId) throws Exception {
        User user = dbUserService.getUSer(userId).orElseThrow(Exception::new);
        user.setActive(false);
        dbUserService.save(user);
    }


}
