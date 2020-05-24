package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto get(final long userId){
        if (userRepository.existsById(userId)){
            User user = userRepository.findById(userId).get();
            return userMapper.mapToDto(user);
        }else {
            throw new RuntimeException("Cannot find User by id: " + userId);
        }
    }

    public boolean delete(final long userId){
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return !userRepository.existsById(userId);
    }

    public UserDto create(final UserDto userDto){
        User user = userMapper.mapToEntity(userDto);
        User saveUser = userRepository.save(user);
        return userMapper.mapToDto(saveUser);
    }

    public UserDto block(final long userId){
        if (userRepository.existsById(userId)){
            User user = userRepository.findById(userId).get();
            user.setStatus(false);
            userRepository.save(user);
            return userMapper.mapToDto(user);
        }else {
            throw new RuntimeException("Cannot find User by id: " + userId);
        }
    }
}
