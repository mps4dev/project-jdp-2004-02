package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapToDto(final User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setStatus(user.isStatus());
        return userDto;
    }

    public User mapToEntity(final UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setStatus(dto.isStatus());
        return user;
    }

    public List<UserDto> mapToDtos(final List<User> users){
        return users.stream()
                .map(user -> mapToDto(user))
                .collect(Collectors.toList());
    }
}
