package com.kodilla.ecommercee.mapper.user;

import com.kodilla.ecommercee.domain.user.User;
import com.kodilla.ecommercee.domain.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto){
        return new User().builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .mail(userDto.getMail())
                .street(userDto.getStreet())
                .code(userDto.getCode())
                .city(userDto.getCity())
                .active(userDto.isActive())
                .build();
    }

    public UserDto mapToUserDto(final User user){
        UserDto userDto = new UserDto().builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mail(user.getMail())
                .street(user.getStreet())
                .code(user.getCode())
                .city(user.getCity())
                .build();
        userDto.setActive(user.isActive());
        return userDto;
    }
    public List<UserDto> mapToUserDtoList(final List<User> userList){
        List<UserDto> dtoList = new ArrayList<>();
        for (User user:userList) {
            dtoList.add(mapToUserDto(user));
        }
        return dtoList;
    }
}
