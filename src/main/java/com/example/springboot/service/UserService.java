package com.example.springboot.service;

import com.example.springboot.models.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

}
