package com.kodilla.ecommercee.service.user;

import com.kodilla.ecommercee.domain.user.User;
import com.kodilla.ecommercee.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbUserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUSer(Long l){
        return userRepository.findById(l);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
