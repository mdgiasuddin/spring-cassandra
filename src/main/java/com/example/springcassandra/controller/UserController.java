package com.example.springcassandra.controller;

import com.example.springcassandra.model.User;
import com.example.springcassandra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @PostConstruct
    public void saveUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(6437, "Basant", "Bangalore", 50));
        users.add(new User(3523, "Saroj", "Pune", 20));
        users.add(new User(8694, "Ravindra", "Mumbai", 30));
        users.add(new User(9854, "Samas", "Odisha", 25));
        userRepository.saveAll(users);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getUserFilterByAge/{age}")
    public List<User> getUserFilterByAge(@PathVariable int age) {
        return userRepository.findByAgeGreaterThan(age);
    }
}
